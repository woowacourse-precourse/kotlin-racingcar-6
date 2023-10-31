import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.service.WinnerService

class WinnerServiceTest {

    @Test
    fun `findWinners - 마지막 라운드의 결과에서 가장 먼 거리를 이동한 차들을 우승자로 반환해야 한다`() {
        val lastRoundResult = mapOf("car1" to 3, "car2" to 3, "car3" to 2)
        val winners = WinnerService.findWinners(lastRoundResult)
        assertEquals(setOf("car1", "car2"), winners)
    }
}
