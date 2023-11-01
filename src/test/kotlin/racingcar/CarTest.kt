package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    var exception = MyException()

    @Test
    fun `자동차_이름_공백`() {
        // given
        var car = Car("")

        //when, then
        assertThrows<IllegalArgumentException> {
            exception.throwNameEmptyException(car.name)
        }
    }

    @Test
    fun `자동차_이름_5초과`() {
        var car = Car("abcdefg")

        assertThrows<IllegalArgumentException> {
            exception.throwNameOverFiveException(car.name)
        }
    }

    @Test
    fun `반복_횟수_문자_입력`() {
        var repeat = "a"
        assertThrows<IllegalArgumentException> {
            exception.throwRepeatStringException(repeat)
        }
    }

    @Test
    fun `반복_횟수_빈칸_입력`() {
        var repeat = ""
        assertThrows<IllegalArgumentException> {
            exception.throwRepeatEmptyException(repeat)
        }
    }
}