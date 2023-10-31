package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class DecisionTest {
    @Test
    fun `filterValues 메서드를 사용해 우승자 반환`() {
        val map = mutableMapOf<String, String>()
        map["minsu"] = "-"
        map["tnal"] = "---"
        map["rnfl"] = "-"
        val longDistance = "---"
        val list = listOf("tnal")
        assertThat(map.filterValues { it == longDistance }.keys.toList()).isEqualTo(list)
    }

    @Test
    fun `난수 값에 따라 전진, 멈춤 반환 확인`() {
        val car = Car("test")
        val randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
        val result = if (randomNumber >= FORWARD_CONDITION_NUMBER) {
            car.moveForward()
        } else {
            car.stop()
        }
        assertThat(result).isEqualTo(1 or 0)

    }

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 9
        private const val FORWARD_CONDITION_NUMBER = 4
    }
}