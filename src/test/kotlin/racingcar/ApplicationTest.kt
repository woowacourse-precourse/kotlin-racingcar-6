package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import racingcar.model.Car
import racingcar.model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.MainController
import racingcar.util.Util.isMovable
import racingcar.util.Util.separateNameByComma
import racingcar.util.Validator.validateInteger
import racingcar.util.Validator.validateLength
import racingcar.util.Validator.validateNotNull
import racingcar.util.Validator.validateRange
import racingcar.util.Validator.validateUnique
import racingcar.view.InputView
import racingcar.view.OutputView

class ApplicationTest : NsTest() {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val controller = MainController(inputView, outputView)

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
    fun `컴마로 구분하여 리스트 반환 검증`() {
        val input = "lh99j,pobi"
        val validation = separateNameByComma(input)
        val result = listOf("lh99j", "pobi")
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `자동차 이름 길이 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateLength(listOf("pobi", "javaji")) }
            assertThrows<IllegalArgumentException> { validateLength(listOf("abcdef, abcdefg")) }

        }
    }

    @Test
    fun `자동차 이름 중복 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateUnique(listOf("pobi", "javaji", "pobi")) }
            assertThrows<IllegalArgumentException> { validateUnique(listOf("a", "b", "c", "a")) }

        }
    }

    @Test
    fun `자동차 이름 널값 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("pobi", "javaji", " ")) }
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("a", "b", "c", "")) }
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("a", "b", "  ")) }
        }
    }

    @Test
    fun `사용자 입력 정수 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateInteger("a") }
            assertThrows<IllegalArgumentException> { validateInteger("1a") }
            assertThrows<IllegalArgumentException> { validateInteger("4_@") }
        }
    }

    @Test
    fun `사용자 입력 유효 범위 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateRange((Int.MAX_VALUE.toLong() + 1).toString()) }
            assertThrows<IllegalArgumentException> { validateRange("-1") }
            assertThrows<IllegalArgumentException> { validateRange("0") }
        }
    }

    @Test
    fun `자동차가 움직였는지 검증`() {
        val car = Car("lh99j")
        car.isMove(true)
        val validation = car.distance
        val result = 1
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `움직일 수 있는지 반환 기능 검증`() {
        val falseInput = 3
        val falseValidation = isMovable(falseInput)
        val falseResult = false
        assertThat(falseValidation).isEqualTo(falseResult)

        val trueInput = 4
        val trueValidation = isMovable(trueInput)
        val trueResult = true
        assertThat(trueValidation).isEqualTo(trueResult)
    }

    @Test
    fun `최대 거리 반환 기능 검증`() {
        val input = listOf("pobi", "lh99j", "anjji", "amin")
        val cars = Cars()
        cars.addAllList(input)
        cars.carNames[1].isMove(true)
        cars.carNames[1].isMove(true)
        cars.carNames[1].isMove(true)
        cars.carNames[1].isMove(true)
        val validation = cars.getMaxDistance()
        val result = 4
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `우승자 확인 기능 검증`() {
        val input = listOf(Car("pobi"), Car("lh99j"), Car("abc"))
        input[1].isMove(true)
        input[1].isMove(true)

        val falseValidation = input[0].isWinner(2)
        val falseResult = false
        assertThat(falseValidation).isEqualTo(falseResult)

        val trueValidation = input[1].isWinner(2)
        val trueResult = true
        assertThat(trueValidation).isEqualTo(trueResult)
    }

    @Test
    fun `우승자 반환 기능 검증`() {
        val input = listOf("pobi", "lh99j", "abcd")
        val cars = Cars()
        cars.addAllList(input)
        cars.carNames[0].isMove(true)
        cars.carNames[1].isMove(true)

        val validation = cars.getWinners()
        val result = listOf("pobi", "lh99j")
        assertThat(validation).isEqualTo(result)
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
