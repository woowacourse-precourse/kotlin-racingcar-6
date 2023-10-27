package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.constants.*
import racingcar.model.Car
import racingcar.util.toCarNameList
import racingcar.model.Try
import racingcar.util.toCarList

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `문자열을 쉼표 기준으로 분리한다`() {
        // given
        val case = "pobi,woni,jun"

        // when
        val result = case.toCarNameList()

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `쉼표가 없는 문자열을 쉼표 기준으로 분리하는 경우 기존 문자열을 반환한다`() {
        // given
        val case = "pobi"

        // when
        val result = case.toCarNameList()

        // then
        assertThat(result).isEqualTo("pobi")
    }

    @Test
    fun `자동차 이름이 1글자 이상 5글자 이하가 아닌 경우 예외가 발생한다`() {
        // given
        val case1 = "pobi"
        val case2 = ""
        val case3 = "thunder"

        // when, then
        assertThatCode { Car.validateNameLength(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Car.validateNameLength(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_LENGTH)

        assertThatThrownBy { Car.validateNameLength(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_LENGTH)
    }

    @Test
    fun `자동차 이름에 영어를 제외한 문자가 포함된 경우 예외가 발생한다`() {
        // given
        val case1 = "pobi"
        val case2 = " pobi "
        val case3 = "pobi2"

        // when, then
        assertThatCode { Car.validateNameLetter(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Car.validateNameLetter(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_LETTER)

        assertThatThrownBy { Car.validateNameLetter(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_LETTER)
    }

    @Test
    fun `시도할 횟수에 숫자가 아닌 문자가 포함된 경우 예외가 발생한다`() {
        // given
        val case1 = "123"
        val case2 = "123 "
        val case3 = "1a"

        // when, then
        assertThatCode { Try.validateTryDigit(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryDigit(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_DIGIT)

        assertThatThrownBy { Try.validateTryDigit(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_DIGIT)
    }

    @Test
    fun `시도할 횟수가 Int의 MAX_VALUE 보다 큰 경우 예외가 발생한다`() {
        // given
        val case1 = "987"
        val case2 = "2147483648"

        // when, then
        assertThatCode { Try.validateTryIntMax(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryIntMax(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_INT_MAX)
    }

    @Test
    fun `시도할 횟수가 0 이하인 경우 예외가 발생한다`() {
        // given
        val case1 = 123
        val case2 = 0
        val case3 = -1

        // when, then
        assertThatCode { Try.validateTryPositive(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryPositive(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_POSITIVE)

        assertThatThrownBy { Try.validateTryPositive(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_POSITIVE)
    }

    @Test
    fun `무작위 값이 4 이상인 경우 자동차를 전진시킬 조건을 충족시킨다`() {
        // given
        val racingGame = RacingGame()
        val case1 = 4
        val case2 = 8
        val case3 = 2

        // when
        val result1 = racingGame.isMovingForward(case1)
        val result2 = racingGame.isMovingForward(case2)
        val result3 = racingGame.isMovingForward(case3)

        // then
        assertThat(result1).isEqualTo(true)
        assertThat(result2).isEqualTo(true)
        assertThat(result3).isEqualTo(false)
    }

    @Test
    fun `자동차 이름이 중복될 경우 예외가 발생한다`() {
        // given
        val racingGame = RacingGame()
        val case1 = listOf("pobi", "woni")
        val case2 = listOf("pobi", "pobi")

        // when, then
        assertThatCode { racingGame.validateCarNameDuplication(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { racingGame.validateCarNameDuplication(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_DUPLICATION)
    }

    @Test
    fun `자동차를 전진시킨다`() {
        // given
        val car = Car.of("pobi")

        // when
        car.moveForward()
        car.moveForward()

        // then
        assertThat(car.racingResult.toString()).isEqualTo("--")
    }

    @Test
    fun `자동차 이름으로 이루어진 리스트를 Car 객체가 담긴 리스트로 변환한다`() {
        // given
        val case = listOf("pobi", "woni", "jun")

        // when
        val result = case.toCarList()

        // then
        result.forEachIndexed { idx, car ->
            assertThat(car).isInstanceOf(Car::class.java)
            assertThat(car.name).isEqualTo(case[idx])
        }
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
