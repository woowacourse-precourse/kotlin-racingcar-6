package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class CarsTest {
    private var cars = Cars()
    @AfterEach
    fun reset(){
        cars = Cars()
    }
    @Test
    fun `addCar 메서드 사용시 Cars 객체에 car가 추가되는지 확인`() {
        //when
        cars.addCar(Car("test"))
        //then
        assertThat(cars.getCars().size).isEqualTo(1)
    }
}