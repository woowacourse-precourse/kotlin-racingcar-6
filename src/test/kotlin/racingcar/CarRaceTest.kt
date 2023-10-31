package racingcar


import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.CarRaceController
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car
import racingcar.view.CarRaceView

class CarRaceTest : NsTest() {

    private val carRaceView = CarRaceView()
    private val carRaceController = CarRaceController(carRaceView)

    @Test
    fun `자동차 이름 입력에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcdef,123456") }
        }
    }

    @Test
    fun `시도 횟수 입력에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("park,sung,hoon", "abc") }
        }
    }

    @Test
    fun `자동차 위치 출력 결과`() {
        val position = 5
        val result = carRaceView.outputCarsPosition(position)
        assertThat(println(result)).isEqualTo(println("-----"))
    }

    @Test
    fun `우승자 출력`() {
        val car1 = Car("a", 3)
        val car2 = Car("b", 4)
        val car3 = Car("c", 2)
        val cars = listOf(car1, car2, car3)

        val winner = carRaceController.choiceWinner(cars)
        assertThat(carRaceController.changeListToStr(winner)).isEqualTo("b")
    }


    override fun runMain() {
        main()
    }
}