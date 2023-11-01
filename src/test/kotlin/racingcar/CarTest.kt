package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun `자동차 객체 생성`(){
        car = Car("seoyeon")
    }

    @Test
    fun `자동차 이름 확인 테스트`() {
        var carName = car.getCarName()
        assertThat("seoyeon").isEqualTo(carName)
    }

    @Test
    fun `자동차 전진 횟수 추가`(){
        car.increaseForwardCount()
        car.increaseForwardCount()

        assertThat(car.getForwardCount()).isEqualTo(2)
    }
}