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
    fun `레이싱카가 추가되는지 테스트`(){
        assert(racingCarsManagement.cars.size==2)
        racingCarsManagement.addRacingCar(RacingCarModel("차3"))
        assert(racingCarsManagement.cars.size==3)
    }

    @Test
    fun `레이싱카 추가되는지 테스트`(){
        val winnersName = racingCarsManagement.getWinners().map { racingCarModel -> racingCarModel.name  }
        val expected = listOf("차1","차2")
        assertEquals(winnersName,expected)
    }
}