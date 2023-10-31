package study.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import racingcar.controller.RacingCarsDTO
import racingcar.model.RacingCarModel

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarsDTOTest {
    private lateinit var racingCarsDTO: RacingCarsDTO

    @BeforeEach
    fun `setUp`(){
        val names = "차1,차2,차3"
        racingCarsDTO = RacingCarsDTO(names)
    }

    @Test
    fun `입력 받은 이름들로 레이싱카 모델이 생성되는지 테스트`(){
        val expected = mutableListOf("차1","차2","차3")
        racingCarsDTO.convertRacingCars().forEach {carName ->
            assert(expected.contains(carName.name))
        }
    }
}