package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CarTest {
    var exception = MyException()
    @Test
    fun `자동차_입력_숫자_4이상`(){
        // given
        var underFour = 7
        var car = Car()

        // when
        car.move(underFour)
        var result = car.count

        // then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `자동차_입력_숫자_4미만`(){
        // given
        var underFour = 3
        var car = Car()

        // when
        car.move(underFour)
        var result = car.count

        // then
        assertThat(result).isEqualTo(0)
    }


    @Test
    fun `자동차_이름_공백`() {
        // given
        var car = Car()
        car.name = ""

        //when, then
        assertThrows<IllegalArgumentException> {
            exception.throwNameEmptyException(car.name)
        }
    }

    @Test
    fun `자동차_이름_5초과`() {
        var car = Car()
        car.name = "abcdefg"

        assertThrows<IllegalArgumentException> {
            exception.throwNameOverFiveException(car.name)
        }
    }

    @Test
    fun `반복_횟수_문자_입력`(){
        var repeat = "a"
        assertThrows<IllegalArgumentException> {
            exception.throwRepeatStringException(repeat)
        }
    }

    @Test
    fun `반복_횟수_빈칸_입력`(){
        var repeat = ""
        assertThrows<IllegalArgumentException> {
            exception.throwRepeatEmptyException(repeat)
        }
    }
}