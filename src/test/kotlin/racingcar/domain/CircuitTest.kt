package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CircuitTest {
    private val circuit = Circuit("test1,test2", 1)

    @Test
    fun `자동차 리스트 생성 테스트 1`() {
        val result = circuit.getCarList()
        assertThat(result).hasSize(2)
    }

    @Test
    fun `자동차 리스트 생성 테스트 2`() {
        val carList = circuit.getCarList()
        val result = carList.map { it.getName() }
        assertThat(result).containsExactly("test1", "test2")
    }

    @Test
    fun `자동차 경주 기능 테스트`() {
        circuit.startRace()
        val carList = circuit.getCarList()
        val result = carList.map { it.getPosition() }
        assertThat(result).allMatch { it in 0..1 }
    }
}