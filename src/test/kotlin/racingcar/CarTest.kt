package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest{

    @Test
    fun `랜덤으로 생성된 숫자가 4미만일 경우 자동차는 전진하지 않는다`(){
        //given
        val car = Car()

        //when

        //then
        val actual = car.tryMoveForward()
        assertThat(actual).isFalse()
    }

    @Test
    fun `랜덤으로 생성된 숫자가 4이상일 경우 자동차는 전진한다`(){
        //given
        val car = Car()

        //when

        //then
        val actual = car.tryMoveForward()
        assertThat(actual).isTrue()
    }
}