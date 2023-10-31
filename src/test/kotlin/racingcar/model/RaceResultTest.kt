package racingcar.model

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class RaceResultTest {
    @Test
    fun `RaceResult 의 toString은 각 CarState과 줄 바꿈을 합쳐서 반환한다`() {
        val carStateList = listOf(
            CarState("murjune", "---"),
            CarState("pobi", "----"),
            CarState("crong", "------")
        )
        val raceResult = RaceResult(carStateList)
        assertThat(raceResult.toString()).isEqualTo("murjune : ---\npobi : ----\ncrong : ------\n")
    }
}