package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.models.CarRaceModel

class CarRaceModelTest {
    private lateinit var carRaceModel: CarRaceModel

    @BeforeEach
    fun setUp() {
        val carNames = listOf("pobi", "woni", "tobi")

        carRaceModel = CarRaceModel()
        carRaceModel.initializeScores(carNames)
    }

    @Test
    fun `updateScores가 4이상이면 score +1 아닐경우 0 에 따른 model 업데이트를 잘해주는지 테스트 `() {
        Assertions.assertRandomNumberInRangeTest(
            {
                carRaceModel.updateScores(listOf("pobi", "woni", "tobi"))
                println(carRaceModel.getScores())
                assertThat(carRaceModel.getScores().toString()).contains("{pobi=1, woni=0, tobi=1}")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `splitWinners가 우승자가 2명일때 잘 반환되는지 테스트`() {
        carRaceModel.setTestCodeDummy(5, 5, 1)
        assertThat(carRaceModel.splitWinners()).contains("pobi, woni")
    }

    @Test
    fun `splitWinners가 우승자가 1명일때 잘 반환되는지 테스트`() {
        carRaceModel.setTestCodeDummy(5, 4, 2)
        assertThat(carRaceModel.splitWinners()).isEqualTo("pobi")
    }

    @Test
    fun `splitCarNames가 ","를 기준으로 잘리는지 확인 테스트`() {
        val carNames = carRaceModel.splitCarNames("pobi,woni,jun")
        assertThat(carNames).contains("pobi", "woni", "jun")
    }

    @Test
    fun `generateResults 점수에 맞게 -를 출력하는지 확인 테스트`() {
        carRaceModel.setTestCodeDummy(3, 2, 3)
        assertEquals("pobi : ---\nwoni : --\ntobi : ---", carRaceModel.generateResults().joinToString("\n"))
    }

    @Test
    fun `getScore이 제대로 작동되는지 테스트`() {
        carRaceModel.setTestCodeDummy(1, 2, 3)
        assertEquals(carRaceModel.getScores().toString(), "{pobi=1, woni=2, tobi=3}")
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}