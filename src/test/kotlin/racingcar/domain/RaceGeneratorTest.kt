package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.res.ErrorMessage.BLANK_CAR_NAME_ERRORMESSAGE
import racingcar.res.ErrorMessage.INDISTINCTIVE_CAR_NAME_ERRORMESSAGE
import racingcar.res.ErrorMessage.NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE
import racingcar.res.ErrorMessage.OVER_5_LETTERS_CAR_NAME_ERRORMESSAGE

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
    val exception = assertThrows<IllegalArgumentException>(NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE) {
      myRace.checkNumberOfMoves(input)
    }
    assertThat(exception.message).isEqualTo(NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE)
  }

  companion object {
    @JvmStatic
    fun goodCarNamesTest() = listOf(
      Arguments.of("pobi", listOf("pobi")),
      Arguments.of("pobi,woni,jun", listOf("pobi", "woni", "jun")),
      Arguments.of("   철수,철  수,제 이 슨", listOf("   철수", "철  수", "제 이 슨")),
    )

    @JvmStatic
    fun badCarNamesTest() = listOf(
      Arguments.of("", BLANK_CAR_NAME_ERRORMESSAGE),
      Arguments.of(",,,", BLANK_CAR_NAME_ERRORMESSAGE),
      Arguments.of("브루스,,", BLANK_CAR_NAME_ERRORMESSAGE),
      Arguments.of("     ,   ,   ", BLANK_CAR_NAME_ERRORMESSAGE),
      Arguments.of("철  수,   ,   영희", BLANK_CAR_NAME_ERRORMESSAGE),
      Arguments.of("one,two,and,overFive", OVER_5_LETTERS_CAR_NAME_ERRORMESSAGE),
      Arguments.of("철수,영희,영희", INDISTINCTIVE_CAR_NAME_ERRORMESSAGE),
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