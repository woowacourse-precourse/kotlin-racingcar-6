package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceGeneratorTest {

  private val myRace = RaceGenerator()

  @Test
  fun `checkCarNames 메서드로 입력 받은 1자 이상, 5자 이하의 올바른 자동차 이름을 쉼표(,)로 구분하여 String 타입의 List에 담기 - 1개인 경우`() {
    val input = "pobi"

    val result = myRace.checkCarNames(input)

    assertThat(result).isEqualTo(listOf("pobi"))
  }

  @Test
  fun `checkCarNames 메서드로 입력 받은 1자 이상, 5자 이하의, 자동차 이름을 쉼표(,)로 구분하여 String 타입의 List에 담기 - 여러 개인 경우`() {
    val input = "pobi,woni,jun"

    val result = myRace.checkCarNames(input)

    assertThat(result).isEqualTo(listOf("pobi", "woni", "jun"))
  }

  @Test
  fun `checkCarNames 메서드 사용시 자동차 이름으로 '아무것도 입력하지 않은' 경우 IllegalArgumentException 발생`() {
    // given
    val input = ""

    // when, then
    assertThrows<IllegalArgumentException>("자동차 이름을 입력해주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkCarNames 메서드 사용시 입력은 있지만 자동차 이름을 입력하지는 않은 경우(",,,") IllegalArgumentException 발생`() {
    val input = ",,,"

    assertThrows<IllegalArgumentException>("자동차 이름을 입력해주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkCarNames 메서드 사용시 입력은 있지만 자동차 이름을 '부분적으로만' 입력한 경우("브루스,,") IllegalArgumentException 발생`() {
    val input = "브루스,,"

    assertThrows<IllegalArgumentException>("자동차 이름을 입력해주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkCarNames 메서드 사용시 자동차 이름 중에 하나라도 5자를 초과하는 경우 IllegalArgumentException 발생`() {
    val input = "one,two,and,overFive"

    assertThrows<IllegalArgumentException>("자동차 이름을 5자 이하로 작성해주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkCarNames 메서드 사용시 '중복된' 자동차 이름을 입력한 경우 IllegalArgumentException 발생`() {
    val input = "철수,영희,영희"

    assertThrows<IllegalArgumentException>("자동차 이름들을 구별되게 지어주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkCarNames 메서드 사용시 '공백'도 구분만 된다면 허용`() {
    val input = "     ,   ,  "  // 공백 5개, 3개, 2개

    val result = myRace.checkCarNames(input)

    assertThat(result).isEqualTo(listOf("     ", "   ", "  "))
  }

  @Test
  fun `checkCarNames 메서드 사용시 '공백'이고 구분도 안 된다면 IllegalArgumentException 발생`() {
    val input = "     ,   ,   "  // 공백 5개, 3개, 3개

    assertThrows<IllegalArgumentException>("자동차 이름들을 구별되게 지어주세요.") {
      myRace.checkCarNames(input)
    }
  }

  @Test
  fun `checkNumberOfMoves 메서드 사용시 '아무것도 입력하지 않은' 경우 IllegalArgumentException 발생`() {
    val input = ""

    assertThrows<IllegalArgumentException>("올바른 횟수를 입력해주세요.") {
      myRace.checkNumberOfMoves(input)
    }
  }

  @Test
  fun `checkNumberOfMoves 메서드 사용시 숫자가 아닌 것을 입력한 경우 IllegalArgumentException 발생`() {
    val input = "$"

    assertThrows<IllegalArgumentException>("올바른 횟수를 입력해주세요.") {
      myRace.checkNumberOfMoves(input)
    }
  }

  @Test
  fun `checkNumberOfMoves 메서드 사용시 숫자이지만 정수가 아닌 수를 입력한 경우 IllegalArgumentException 발생`() {
    val input = "5.4"

    assertThrows<IllegalArgumentException>("올바른 횟수를 입력해주세요.") {
      myRace.checkNumberOfMoves(input)
    }
  }

  @Test
  fun `checkNumberOfMoves 메서드 사용시 숫자이고 정수이지만 음수를 입력한 경우 IllegalArgumentException 발생`() {
    val input = "-3"

    assertThrows<IllegalArgumentException>("올바른 횟수를 입력해주세요.") {
      myRace.checkNumberOfMoves(input)
    }
  }

  @Test
  fun `checkNumberOfMoves 메서드 사용시 0 이상의 정수를 잘 입력한 경우 숫자로 변환하여 반환`() {
    val input = "6"

    val result = myRace.checkNumberOfMoves(input)

    assertThat(result).isEqualTo(6)
  }
}