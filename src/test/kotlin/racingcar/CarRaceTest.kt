package racingcar


import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.CarRaceController
import org.assertj.core.api.Assertions.assertThat
import racingcar.view.CarRaceView

class CarRaceTest : NsTest() {

    val carRaceView = CarRaceView()
    val carRaceController = CarRaceController(carRaceView)

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
    fun `자동차들의 위치 출력 결과`() {
        val position = 5
        val result = carRaceController.showCars(position)
        assertThat(result).isEqualTo("-----")
    }


    override fun runMain() {
        main()
    }
}