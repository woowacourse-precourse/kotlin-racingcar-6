package study.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import racingcar.model.RacingCarModel
import racingcar.model.RoundModel

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoundModelTest {
    lateinit var roundModel: RoundModel

    @BeforeEach
    fun `setUp`() {
        roundModel = RoundModel(1, mutableListOf(RacingCarModel("차1"), RacingCarModel("차2"), RacingCarModel("차3")))
    }

    @Test
    fun `라운드 결과 테스트`(){
        val expected = "차2"
        assert(roundModel.getRacingResult().contains(expected))
    }

}