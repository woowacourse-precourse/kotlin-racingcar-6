package racingcar

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racingcar.utils.Exception.requirePositiveInt
import racingcar.utils.Exception.requireValidCarNames
import racingcar.utils.Exception.requireValidPositiveInt

class ExceptionTest {

    @Test
    fun `Given 유효한 차량 이름이 주어진 경우, When requireValidCarNames를 호출하면 Then 예외가 발생하지 않아야 함`() {
        // Given
        val input = "Car1,Car2,Car3"

        // When & Then
        assertThatCode { input.requireValidCarNames() }.doesNotThrowAnyException()
    }

    @Test
    fun `Given 유효하지 않은 차량 이름이 주어진 경우, When requireValidCarNames를 호출하면 Then IllegalArgumentException이 발생해야 함`() {
        // Given
        val input = "Car1,Car2,Car345"

        // When & Then
        assertThatIllegalArgumentException().isThrownBy { input.requireValidCarNames() }
    }


    @Test
    fun `Given 유효하지 않은 입력이 주어진 경우, When requireValidPositiveInt를 호출하면 Then IllegalArgumentException이 발생해야 함`() {
        // Given
        val input = "junjange"

        // When & Then
        assertThatIllegalArgumentException().isThrownBy { input.requireValidPositiveInt() }
    }

    @Test
    fun `Given 양의 정수가 주어진 경우, When requirePositiveInt를 호출하면 Then 예외가 발생하지 않아야 함`() {
        // Given
        val input = "5"

        // When & Then
        assertThatCode { input.requireValidPositiveInt() }.doesNotThrowAnyException()
    }

    @Test
    fun `Given 양수가 아닌 정수가 주어진 경우, When requirePositiveInt를 호출하면 Then IllegalArgumentException이 발생해야 함`() {
        // Given
        val input = "0"

        // When & Then
        assertThatIllegalArgumentException().isThrownBy { input.requirePositiveInt() }
    }
}