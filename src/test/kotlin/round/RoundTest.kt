package round

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.car.Car

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "@", "가", "", " "])
    fun `게임 라운드에 숫자 이외의 값이 들어오면 예외를 던진다`(input: String) {
        assertThrows<IllegalArgumentException>("입력값은 숫자여야 합니다.") {
            require(input.toIntOrNull() != null)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-3, -1, 0])
    fun `게임 라운드가 1회 미만일 때 예외를 던진다`(round: Int) {
        assertThrows<IllegalArgumentException>("입력값은 숫자여야 합니다.") {
            require(round > 1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤으로 뽑힌 숫자가 4이상일 때 자동차가 전진한다`(number: Int) {
        val expectedCar = Car("jiyeon", 0)
        if (number >= 4) expectedCar.scoreSum++
        val actualCar = Car("jiyeon", 1)
        assertThat(actualCar).isEqualTo(expectedCar)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤으로 뽑힌 숫자가 4미만일 때 자동차는 정지한다`(number: Int) {
        val expectedCar = Car("jiyeon", 0)
        if (number >= 4) expectedCar.scoreSum++
        val actualCar = Car("jiyeon", 0)
        assertThat(actualCar).isEqualTo(expectedCar)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `누적된 점수만큼 자동차의 이동경로를 출력한다`(move: Int) {
        val expectedMovement = "-".repeat(Car("jiyeon", move).scoreSum)
        val actualMovement = "-".repeat(move)
        assertThat(actualMovement).isEqualTo(expectedMovement)
    }

}