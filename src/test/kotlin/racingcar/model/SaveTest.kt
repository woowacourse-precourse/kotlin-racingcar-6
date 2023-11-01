package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SaveTest {
    @Test
    fun `전진, 멈춤 거리 추가`() {
        val distance = mutableListOf("", "--", "-")
        val index = 1
        val move = GO
        when (move) {
            GO -> distance[index] += GO_STRING
            STOP -> distance[index] += STOP_STRING
        }
        assertThat(distance[index]).isEqualTo("---")
    }

    companion object {
        private const val GO = 1
        private const val STOP = 0
        private const val GO_STRING = "-"
        private const val STOP_STRING = ""
    }
}