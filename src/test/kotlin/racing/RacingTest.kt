package racing

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Racing


class RacingTest {
    private var racing: Racing = Racing()

    @Test
    fun `자동차 추가 테스트`() {
        racing.addCar("Car1")
        racing.addCar("Car2")
        assertEquals(2, racing.getCars().size)
    }
    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { racing.addCar("pobi,veryLongName") }
        }
    }

}