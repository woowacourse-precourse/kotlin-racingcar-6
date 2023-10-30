package racingcar.domain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import org.assertj.core.api.Assertions.assertThat
import racingcar.cars
import racingcar.controller

class ControllerTest {
    @AfterEach
    fun reset(){
        cars = Cars()
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
        assertThat(controller.printWinner(cars)).isEqualTo("최종 우승자 : pobi")
    }
    @Test
    fun `printWinner 메서드 사용시 공동 우승일 때`() {
        //given
        cars.addCar(Car("pobi"))
        cars.addCar(Car("joon"))
        cars.addCar(Car("java"))

        //then
        assertThat(controller.printWinner(cars)).isEqualTo("최종 우승자 : pobi, joon, java")
    }

    @Test
    fun `playRound 메서드 사용해 pobi가 1칸 전진 후 결과 출력`() {
        //given
        val car = Car("pobi")

        //when
        controller.playRound(car,5)

        //then
        assertThat(car.printResult()).isEqualTo("pobi : -")
    }
}