package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameManagerTest {

    @Test
    fun `전진을 시도할 횟수에 문자열을 넣을 수 없다`() {
        //given
        val gameManager = GameManager()
        val input = "tgyuu"

        //when


        //then
        assertThrows<IllegalArgumentException> {
            gameManager.setMovementAttemptCount(input)
        }
    }

    @Test
    fun `전진을 시도할 횟수에 음수를 넣을 수 없다`() {
        //given
        val gameManager = GameManager()
        val input = "-1"

        //when


        //then
        assertThrows<IllegalArgumentException> {
            gameManager.setMovementAttemptCount(input)
        }
    }
}