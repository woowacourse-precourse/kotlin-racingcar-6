package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarStateTest {
    @Test
    fun `CarState 의 toString은 차의 이름과 위치를 반환한다`() {
        val name = "murjune"
        val position = "---"
        val carState = CarState(name, position)
        assertThat(carState.toString()).isEqualTo("murjune : ---")
    }
}