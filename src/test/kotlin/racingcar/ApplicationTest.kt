package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.constants.*
import racingcar.io.printCarsResult
import racingcar.io.printWinners
import racingcar.model.Car
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
    fun `자동차 이름으로 이루어진 문자열을 Car 객체가 담긴 리스트로 변환한다`() {
        // given
        val case1 = "pobi,woni,jun"
        val case2 = "pobi"

        // when
        val result1 = case1.toCarList()
        val result2 = case2.toCarList()

        // then
        result1.forEachIndexed { idx, car ->
            assertThat(car).isInstanceOf(Car::class.java)
            assertThat(car.toString()).isEqualTo(case1.split(",")[idx])
        }

        result2.forEachIndexed { idx, car ->
            assertThat(car).isInstanceOf(Car::class.java)
            assertThat(car.toString()).isEqualTo(case2.split(",")[idx])
        }
    }

    @Test
    fun `자동차 이름이 5글자 이상인 경우 예외가 발생한다`() {
        // given
        val case1 = "pobi"
        val case2 = "thunder"

        // when, then
        assertThatCode { Car.validateNameLength(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Car.validateNameLength(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.LENGTH.toString())
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
            .hasMessage(CarException.LETTER.toString())

        assertThatThrownBy { Car.validateNameLetter(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.LETTER.toString())
    }

    @Test
    fun `자동차 이름을 구분하는 콤마를 입력값 뒤에 붙이는 경우 예외가 발생한다`() {
        // given
        val racingGame = RacingGame()
        val case = "pobi,woni,"

        // when, then
        assertThatThrownBy { racingGame.validateCarNameComma(case) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.COMMA.toString())
    }

    @Test
    fun `자동차 이름을 구분하는 콤마를 입력값 앞에 붙이는 경우 예외가 발생한다`() {
        // given
        val racingGame = RacingGame()
        val case = ",pobi,woni"

        // when, then
        assertThatThrownBy { racingGame.validateCarNameComma(case) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.COMMA.toString())
    }

    @Test
    fun `자동차 이름을 구분하는 콤마를 연속으로 두번 이상 입력하는 경우 예외가 발생한다`() {
        // given
        val racingGame = RacingGame()
        val case = "pobi,,woni"

        // when, then
        assertThatThrownBy { racingGame.validateCarNameComma(case) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.COMMA.toString())
    }

    @Test
    fun `시도할 횟수를 입력하지 않은 경우 예외가 발생한다`() {
        // given
        val case1 = "123"
        val case2 = ""

        // when, then
        assertThatCode { Try.validateTryEmpty(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryEmpty(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(TryException.EMPTY.toString())
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
            .hasMessage(TryException.DIGIT.toString())

        assertThatThrownBy { Try.validateTryDigit(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(TryException.DIGIT.toString())
    }

    @Test
    fun `시도할 횟수가 Int의 MAX_VALUE 보다 큰 경우 예외가 발생한다`() {
        // given
        val case1 = "987"
        val case2 = "2147483648"

        // when, then
        assertThatCode { Try.validateTryMax(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryMax(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(TryException.MAX.toString())
    }

    @Test
    fun `시도할 횟수가 0 이하인 경우 예외가 발생한다`() {
        // given
        val case1 = 123
        val case2 = 0
        val case3 = -1

        // when, then
        assertThatCode { Try.validateTryMin(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { Try.validateTryMin(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(TryException.MIN.toString())

        assertThatThrownBy { Try.validateTryMin(case3) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(TryException.MIN.toString())
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
        val case1 = listOf(Car.of("pobi"), Car.of("woni"))
        val case2 = listOf(Car.of("pobi"), Car.of("pobi"))

        // when, then
        assertThatCode { racingGame.validateCarNameDuplication(case1) }
            .doesNotThrowAnyException()

        assertThatThrownBy { racingGame.validateCarNameDuplication(case2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CarException.DUPLICATION.toString())
    }

    @Test
    fun `자동차를 전진시킨다`() {
        // given
        val case = Car.of("pobi")

        // when
        case.moveForward()
        case.moveForward()
        val result = case.getRacingResultString()

        // then
        assertThat(result).isEqualTo("pobi : --")
    }

    @Test
    fun `Car 객체의 대소비교는 forwardCount 변수의 값을 비교한다`() {
        // given
        val case1 = listOf(Car.of("pobi"), Car.of("woni"))
        val case2 = listOf(Car.of("pobi").apply { moveForward() }, Car.of("woni"))
        val case3 = listOf(Car.of("pobi"), Car.of("woni").apply { moveForward() })

        // when
        val result1 = case1[0].compareTo(case1[1])
        val result2 = case2[0].compareTo(case2[1])
        val result3 = case3[0].compareTo(case3[1])

        // then
        assertThat(result1).isEqualTo(0)
        assertThat(result2).isEqualTo(-1)
        assertThat(result3).isEqualTo(1)
    }

    @Test
    fun `Car 객체가 전진한 횟수에 따라 우승자를 가려낸다`() {
        // given
        val racingGame = RacingGame()
        val case = listOf(
            Car.of("pobi"),
            Car.of("woni").apply {
                moveForward()
                moveForward()
            },
            Car.of("jun").apply {
                moveForward()
            }
        )

        // when
        val result = racingGame.pickWinners(case)

        // then
        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].toString()).isEqualTo("woni")
    }

    @Test
    fun `우승자가 여러명인 경우 입력된 순서대로 우승자의 순서가 정해진다`() {
        // given
        val racingGame = RacingGame()
        val case = listOf(
            Car.of("pobi"),
            Car.of("woni").apply {
                moveForward()
            },
            Car.of("jun").apply {
                moveForward()
            }
        )

        // when
        val result = racingGame.pickWinners(case)

        // then
        assertThat(result.size).isEqualTo(2)
        assertThat(result[0].toString()).isEqualTo("woni")
        assertThat(result[1].toString()).isEqualTo("jun")
    }

    @Test
    fun `차수별 실행 결과를 형식에 맞게 출력한다`() {
        // given
        val case = listOf(
            Car.of("pobi"),
            Car.of("woni").apply {
                moveForward()
                moveForward()
            },
            Car.of("jun").apply {
                moveForward()
            }
        )

        // when
        printCarsResult(case)

        // then
        assertThat(output())
            .isEqualTo(
                "pobi : \r\n" +
                        "woni : --\r\n" +
                        "jun : -"
            )
    }

    @Test
    fun `최종 우승자를 출력한다`() {
        // given
        val case = listOf(Car.of("pobi"))

        // when
        printWinners(case)

        // then
        assertThat(output()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `최종 우승자가 여러명인 경우 이름을 쉼표로 구분하여 출력한다`() {
        // given
        val case = listOf(Car.of("pobi"), Car.of("woni"))

        // when
        printWinners(case)

        // then
        assertThat(output()).isEqualTo("최종 우승자 : pobi, woni")
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
