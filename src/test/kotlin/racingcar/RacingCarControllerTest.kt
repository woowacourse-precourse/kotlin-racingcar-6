package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarController
import racingcar.model.Car
import racingcar.view.RacingCarView

class RacingCarControllerTest {
    private lateinit var racingCarController: RacingCarController

    @BeforeEach
    fun `컨트롤러 초기화`() {
        var racingCarView = RacingCarView()
        racingCarController = RacingCarController(racingCarView)
    }

    @Test
    fun `자동차 객체 초기화`() {
        val carNames = listOf("car1", "car2", "car3")
        racingCarController.initializeCars(carNames)
        val initializedCarList = racingCarController.getCarList()
        assertThat(initializedCarList.map { it.getCarName() }).containsExactlyElementsOf(carNames)
    }

    @Test
    fun `랜덤 난수에 따른 자동차 전진 여부 확인`() {
        var car = Car("ab")
        racingCarController.moveForwardCar(car, 7)
        racingCarController.moveForwardCar(car, 2)
        assertThat(car.getForwardCount()).isEqualTo(1)
    }

    @Test
    fun `범위에 맞는 랜덤 난수 생성 여부 확인`() {
        var num = racingCarController.generateRandomNum(5, 9)
        assertThat(num).isGreaterThanOrEqualTo(5)
        assertThat(num).isLessThanOrEqualTo(9)
    }

    @Test
    fun `최종 우승자 선정 확인 테스트`() {
        var carList = mutableListOf<Car>(
            Car("a"), Car("b"), Car("c"), Car("d")
        )
        racingCarController.moveForwardCar(carList[0], 7)
        racingCarController.moveForwardCar(carList[2], 7)
        racingCarController.moveForwardCar(carList[2], 7)
        racingCarController.moveForwardCar(carList[3], 7)
        racingCarController.moveForwardCar(carList[3], 7)

        var finalWinnerList = racingCarController.selectFinalWinner(carList)
        assertThat(finalWinnerList).containsExactly(carList[2], carList[3])
    }
}