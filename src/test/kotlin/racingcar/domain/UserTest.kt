package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.car.Cars

class UserTest {
    val user = User()
    @Test
    fun `askCarName 메서드 사용시 이름이 5자 이상일 때 예외 발생`() {
        //given
        val input = "pobi,java,joontae,car"

        //then
        assertThrows<IllegalArgumentException>("String index out of range: 5") {
            user.askCarName(
                input, cars = Cars()
            )
        }
    }

    @Test
    fun `askNumber 메서드 문자 입력 시 예외 발생`() {
        //given
        val input = "1"
        val result = 1

        //then
        assertThat(user.askNumber(input)).isEqualTo(result)
    }
}