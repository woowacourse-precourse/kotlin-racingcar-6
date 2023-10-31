package racingcar


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows
import racingcar.Model.ForwardOrWaitCheck
import racingcar.Model.UserInputCheck
import racingcar.Model.WinnerSelect


class GameTest {


    @Test
    fun `자동차 이름 입력 받기`() {

        var userInput="차1,차2,차3"
        val result=UserInputCheck().carNameErrorController(userInput)
        assert(result == listOf("차1", "차2", "차3"))
    }
    @Test
    fun `6자리 이상의 자동차 이름 입력 받기`() {

        var userInput="차12345,차2"
        assertThrows<IllegalArgumentException> {
            UserInputCheck().carNameErrorController(userInput)
        }
    }

    @Test
    fun `중복된 자동차의 이름을 입력 받기`() {

        var userInput="차1,차1"
        assertThrows<IllegalArgumentException> {
            UserInputCheck().carNameErrorController(userInput)

        }
    }

    @Test
    fun `라운드 수 입력 받기`() {

        var userInput="3"
        val result=UserInputCheck().roundNumberErrorController(userInput)
        assert(result == 3)
    }
    @Test
    fun `잘못된 라운드 수 입력 받기`() {

        var userInput="-2"
        assertThrows<IllegalArgumentException> {
            UserInputCheck().roundNumberErrorController(userInput)
        }
    }

    @Test
    fun `한번의 라운드 마다 입력된 자동차의 수 만큼 전진 및 정지 여부를 저장`() {
        val roundScore = mutableListOf<Boolean>()
        val carName= mutableListOf("가","나","다")

        for(i in carName.indices) {
            val personalScore = ForwardOrWaitCheck().oneRoundPersonalScore()
            roundScore.add(personalScore)
        }
        assertTrue(roundScore.size == carName.size)
    }

    @Test
    fun `우승자 결정`() {

        val finalScore= mutableMapOf(
            "가" to 3,
            "나" to 3,
            "다" to 2
        )
        val winners=WinnerSelect().raceWinnerSelect(finalScore)
        assertEquals(listOf("가","나"),winners)
    }


}

