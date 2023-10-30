package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.fake.FakeNumberGenerator
import racingcar.state.CarState

class CarTest{

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "tgyuu"])
    fun `자동차의 이름은 1글자 이상 5글자 이하여야 한다`(carName : String){
        //given


        //when


        //then
        assertDoesNotThrow {
            Car(name= carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef","tgyuuJJang", ""])
    fun `자동차의 이름은 6글자 이상이거나 공백일 수 없다`(carName : String){
        //given


        //when


        //then
        assertThrows<IllegalArgumentException> {
            Car(name= carName)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4,5,6,7,8,9])
    fun `랜덤으로 생성된 숫자가 4이상 일 경우, 자동차는 전진할 수 있다`(input : Int){
        //given
        val fakeNumberGenerator : NumberGenerator = FakeNumberGenerator(input)
        val car = Car(name = "tgyuu", numberGenerator = fakeNumberGenerator)

        //when


        //then
        val actual = car.tryForwardMovement()
        val expected = CarState.MOVING_FORWARD
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3])
    fun `랜덤으로 생성된 숫자가 4미만 일 경우, 자동차는 전진할 수 없다`(input : Int){
        //given
        val fakeNumberGenerator : NumberGenerator = FakeNumberGenerator(input)
        val car = Car(name = "tgyuu", numberGenerator = fakeNumberGenerator)

        //when


        //then
        val actual = car.tryForwardMovement()
        val expected = CarState.STOP
        assertThat(actual).isEqualTo(expected)
    }
}