package round

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
}