package study.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import racingcar.controller.RoundDTO

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoundDTOTest {
    lateinit var roundDTO: RoundDTO

    @BeforeEach
    fun `setUp`(){
        roundDTO = RoundDTO("1")
    }

    @Test
    fun `Int타입으로 반환하는지 테스트`(){
        assert(roundDTO.convertRoundCount() is Int)
    }
}