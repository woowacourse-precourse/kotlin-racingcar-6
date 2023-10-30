package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
    fun `자동차의 이름은 1글자 이상 5글자 이하여야 한다`(carName : String){
        //given

        //when


        //then
        assertDoesNotThrow {
            Car(name= carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef","abcdefg", ""])
    fun `자동차의 이름은 6글자 이상이거나 공백일 수 없다`(carName : String){
        //given

        //when


        //then
        assertThrows<IllegalArgumentException> {
            Car(name= carName)
        }
    }
}