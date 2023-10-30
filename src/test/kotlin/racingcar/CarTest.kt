package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest{

    val fakeNumberGenerator : NumberGenerator = FakeNumberGenerator()

    @Test
    fun `랜덤으로 생성된 숫자가 4일 경우 자동차는 전진할 수 있다`(){
        //given
        val car = Car(name = "tgyuu", numberGenerator = fakeNumberGenerator)

        //when

        //then
        val actual = car.isPossibleMoveForward()
        assertThat(actual).isTrue()
    }
}