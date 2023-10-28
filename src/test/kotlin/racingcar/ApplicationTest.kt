package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.GameController
import racingcar.model.Car
import racingcar.model.Cars

class ApplicationTest : NsTest() {
    val gameController = GameController()
    val POBI = "pobi"
    val JSON = "json"

    @Test
    fun `공백 제거후 리스트로 반환 되는지`() {
        val carNames = gameController.inputCarNames("  $POBI,  $JSON  ")
        val cars = Cars(carNames.map { Car(it) })
        // 순서를 고려할 필요는 없지만, Exactly 사용
        Assertions.assertEquals(Cars(listOf(Car(POBI), Car(JSON))), cars)
    }

    @Test
    fun `split 메서드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환`() {
        val result = Car("  $POBI")
        Assertions.assertEquals(Car(POBI), result)
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
