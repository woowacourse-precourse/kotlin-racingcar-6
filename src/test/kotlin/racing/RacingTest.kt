package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.Racing

class RacingTest {
    private var racing: Racing = Racing()

    @Test
    fun `자동차 추가 테스트`() {
        racing.addCar("Car1")
        racing.addCar("Car2")
        assertEquals(2, racing.getCars().size)
    }


}