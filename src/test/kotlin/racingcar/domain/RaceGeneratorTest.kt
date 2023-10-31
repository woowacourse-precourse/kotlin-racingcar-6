package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RaceGeneratorTest {

  private lateinit var myRace: RaceGenerator

  @BeforeEach
  fun setUp() {
    myRace = RaceGenerator()
  }

  @DisplayName("checkCarNames 메서드 테스트 - 정상적인 입력")
  @ParameterizedTest
  @MethodSource("goodCarNamesTest")
  fun goodCarNamesTest(input: String, expected: List<String>) {
    val actual = myRace.checkCarNames(input)

    assertThat(actual).isEqualTo(expected)
  }

  @DisplayName("checkCarNames 메서드 테스트 - 비정상적인 입력")
  @ParameterizedTest
  @MethodSource("badCarNamesTest")
  fun badCarNamesTest(input: String, message: String) {
    val exception = assertThrows<IllegalArgumentException>(message) {
      myRace.checkCarNames(input)
    }
    assertThat(message).isEqualTo(exception.message)
  }

  @DisplayName("checkNumberOfMoves 메서드 테스트 - 정상적인 입력")
  @ParameterizedTest
  @MethodSource("goodNumberOfMovesTest")
  fun goodNumberOfMovesTest(input: String, expected: Int) {
    val actual = myRace.checkNumberOfMoves(input)

    assertThat(actual).isEqualTo(expected)
  }

  @DisplayName("checkNumberOfMoves 메서드 테스트 - 비정상적인 입력")
  @ParameterizedTest
  @MethodSource("badNumberOfMovesTest")
  fun badNumberOfMovesTest(input: String) {
    val exception = assertThrows<IllegalArgumentException>("올바른 횟수를 입력해주세요.") {
      myRace.checkNumberOfMoves(input)
    }
    assertThat(exception.message).isEqualTo("올바른 횟수를 입력해주세요.")
  }

  companion object {
    @JvmStatic
    fun goodCarNamesTest() = listOf(
      Arguments.of("pobi", listOf("pobi")),
      Arguments.of("pobi,woni,jun", listOf("pobi", "woni", "jun")),
      Arguments.of("     ,   ,  ", listOf("     ", "   ", "  ")), // 공백 5개, 3개, 2개
    )

    @JvmStatic
    fun badCarNamesTest() = listOf(
      Arguments.of("", "자동차 이름을 입력해주세요."),
      Arguments.of(",,,", "자동차 이름을 입력해주세요."),
      Arguments.of("브루스,,", "자동차 이름을 입력해주세요."),
      Arguments.of("one,two,and,overFive", "자동차 이름을 5자 이하로 작성해주세요."),
      Arguments.of("철수,영희,영희", "자동차 이름들을 구별되게 지어주세요."),
      Arguments.of("     ,   ,   ", "자동차 이름들을 구별되게 지어주세요."),  // 공백 5개, 3개, 3개
    )

    @JvmStatic
    fun goodNumberOfMovesTest() = listOf(
      Arguments.of("6", 6),
      Arguments.of("0099", 99),
      Arguments.of("0", 0),
    )

    @JvmStatic
    fun badNumberOfMovesTest() = listOf(
      Arguments.of(""),
      Arguments.of("$"),
      Arguments.of("5.4"),
      Arguments.of("-3"),
      Arguments.of("24*4"),
      Arguments.of("24-4"),
    )
  }
}