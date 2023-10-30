package racingcar.domain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import racingcar.controller
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import org.assertj.core.api.Assertions.assertThat

class ControllerTest {
    private var cars = Cars()
    @AfterEach
    fun reset(){
        cars = Cars()
    }
    @Test
    fun `playRount 메서드 사용 후 모든 자동차의 랜덤값이 5인걸로 가정하고 자동차 전체 distance 값이 1 증가`() {
        //given
        cars.addCar(Car("test"))
        cars.addCar(Car("joon"))

        //when
        controller.playRound(cars,5)

        //then
        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1)
        assertThat(cars.getCars().get(1).getDistance()).isEqualTo(1)
    }

    @Test
    fun `playRount 메서드 사용 후 모든 자동차의 랜덤값이 0인걸로 가정하고 자동차 전체 distance 그대로 0`() {
        //given
        cars.addCar(Car("test"))
        cars.addCar(Car("joon"))

        //when
        controller.playRound(cars,0)

        //then
        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(0)
        assertThat(cars.getCars().get(1).getDistance()).isEqualTo(0)
    }
    @Test
    fun `printWinner 메서드 사용시 단독 우승일 때`() {
        //given
        cars.addCar(Car("pobi"))
        cars.addCar(Car("joon"))
        cars.addCar(Car("java"))
        cars.getCars().get(0).move(6)
        cars.compareHighScore(1)

        //then
        assertThat(controller.printWinner(cars)).isEqualTo("최종 우승자 : pobi\n")
    }
    @Test
    fun `printWinner 메서드 사용시 공동 우승일 때`() {
        //given
        cars.addCar(Car("pobi"))
        cars.addCar(Car("joon"))
        cars.addCar(Car("java"))

        //then
        assertThat(controller.printWinner(cars)).isEqualTo("최종 우승자 : pobi, joon, java\n")
    }
}