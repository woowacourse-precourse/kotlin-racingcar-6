package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.controller.GameController
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Repetition
import racingcar.view.InputView

class ApplicationTest : NsTest() {
    val gameController = GameController()
    val inputView = InputView()
    val POBI = "pobi"
    val JSON = "json"

    @Test
    fun `공백 제거후 리스트로 반환 되는지`() {
        val carNameList = inputView.splitCarNamesByComma("  $POBI,  $JSON  ")
        val cars = Cars.fromNames(carNameList)

        Assertions.assertEquals(Cars(listOf(Car(POBI), Car(JSON))), cars)
    }

    @Test
    fun `자동차 이름 중복 입력 오류테스트`() {
        assertThrows<IllegalArgumentException> {
            val carNameList = inputView.splitCarNamesByComma("$POBI,$JSON,$POBI")
            Cars.fromNames(carNameList)
        }
    }

    @Test
    fun `반복 횟수 입력 오류테스트`() {
        val TestExceptionList = listOf("a", "^", "0", "-1")

        TestExceptionList.forEach {
            assertThrows<IllegalArgumentException> {
                Repetition(it)
            }
        }
    }

    @Test
    fun `반복 횟수 입력 테스트`() {
        val TestList = listOf("1", "512", "123")

        TestList.forEach {
            assertDoesNotThrow {
                Repetition(it)
            }
        }
    }

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

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
