package study.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import racingcar.controller.RacingCarsManagement
import racingcar.model.RacingCarModel

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingGameManagementTest {
    lateinit var racingCarsManagement: RacingCarsManagement

    @BeforeEach
    fun `setUp`(){
        racingCarsManagement = RacingCarsManagement(mutableListOf(RacingCarModel("차1"),RacingCarModel("차2")))
    }

    @Test
    fun `우승자가 맞게 출력되는지 테스트`(){
        val winnersName = racingCarsManagement.getWinners()
        val expected = "차1, 차2"
        assertEquals(winnersName,expected)
    }
}