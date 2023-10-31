package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class RacingControllerTest {
    @Test
    fun `player 수만큼 distance List 요소 생성`() {
        val playerList = listOf("test1", "test2", "test3")
        val distanceList = MutableList(playerList.size) { "" }
        assertThat(distanceList.size).isEqualTo(playerList.size)
    }

    @Test
    fun `map 메서드를 통해 Car List 반환`() {
        val nameList = listOf("test1", "test2", "test3")
        val result = nameList.map { name -> Car(name) }
        val testList = listOf(Car("test1"), Car("test2"), Car("test3"))

        repeat(nameList.size) { index ->
            assertThat(result[index].name).isEqualTo(testList[index].name)
        }
    }
}