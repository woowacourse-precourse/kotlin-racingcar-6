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
    @Test
    fun `compareHighScore 메서드 사용시 파라미터 값을 Highscore와 비교 후 크다면 파라미터 값을 HighScore로 설정`() {
        //when
        cars.compareHighScore(5)

        //then
        assertThat(cars).extracting("highScore").isEqualTo(5)
    }
    @Test
    fun `isEqualHighScore 메서드 사용시 파라미터의 숫자와 HighScore의 값이 같은지 비교`() {
        //when
        cars.addCar(Car("test"))
        cars.compareHighScore(3)

        //then
        assertThat(cars.isEqualHighScore(3)).isEqualTo(true)
    }
    @Test
    fun `isFirst 메서드를 처음 사용한다면 true를 반환`() {
        //then
        assertThat(cars.isFirst()).isEqualTo(true)
    }

    @Test
    fun `isFirst 메서드를 다시 사용한다면 true를 반환`() {
        //when
        cars.isFirst()
        //then
        assertThat(cars.isFirst()).isEqualTo(false)
    }
}