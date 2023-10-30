package racingcar

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `자동차를 추가하면, 해당 자동차의 이름을 key로 하는 entry가 생성된다`() {
        //given
        val gameManager = GameManager()
        val input = Car(name = "tgyuu")


        //when
        gameManager.addCarToGame(input)


        //then
        val actual = gameManager.movedDirection.containsKey(input.name)
        assertThat(actual).isTrue()
    }
}