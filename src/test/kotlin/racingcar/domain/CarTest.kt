package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals

class CarTest {
    @Test
    fun `move 작동 테스트`(){
        //given
        val testCar = Car("test")
        //when
        testCar.move()
        //then
        assertThat(testCar.getDistance()).isEqualTo(1)
    }
}