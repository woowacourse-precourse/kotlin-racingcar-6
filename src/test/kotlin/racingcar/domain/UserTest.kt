package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.car.Cars
import racingcar.user

class UserTest {
    val user = User()

    @Test
    fun `askCarName 메서드 사용시 이름이 5자 이상일 때 예외 발생`() {
        //given
        val input = "pobi,java,joontae,car"

        //then
        assertThrows<IllegalArgumentException>("차의 이름 길이가 5 이하 이어야 합니다.") {
            user.askCarName(
                input, cars = Cars()
            )
        }
    }

    @Test
    fun `askCarName 메서드 사용시 이름이 특수 문자를 포함할 때 예외 발생`() {
        //given
        val input = "!!!"

        //then
        assertThrows<IllegalArgumentException>("차의 이름은 특수 문자를 포함할 수 없습니다.") {
            user.askCarName(
                input, cars = Cars()
            )
        }
    }

    @Test
    fun `askCarName 메서드 사용시 이름이 공백일 때 예외 발생`() {
        //given
        val input = "pobi,java,,car"

        //then
        assertThrows<IllegalArgumentException>("차의 이름이 공백일 수 없습니다.") {
            user.askCarName(
                input, cars = Cars()
            )
        }
    }
    @Test
    fun `askNumber 메서드 공백일 시 예외 발생`() {
        //given
        val input = ""

        //then
        assertThrows<IllegalArgumentException>("시도할 횟수가 공백일 수 없습니다.") {
            user.askNumber(
                input
            )
        }
    }
    @Test
    fun `askNumber 메서드 문자 입력 시 예외 발생`() {
        //given
        val input = "hi"

        //then
        assertThrows<IllegalArgumentException>("시도할 횟수는 정수 이어야 합니다.") {
            user.askNumber(
                input
            )
        }
    }
    @Test
    fun `askNumber 메서드 입력이 0보다 작을 때 예외 발생`() {
        //given
        val input = "-5"

        //then
        assertThrows<IllegalArgumentException>("시도할 횟수는 정수 이어야 합니다.") {
            user.askNumber(
                input
            )
        }
    }
}