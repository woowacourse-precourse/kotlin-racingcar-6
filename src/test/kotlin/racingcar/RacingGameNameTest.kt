package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameNameTest {

    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame(Printer())
    }

    @Test
    fun `이름이 공백일 예외 케이스`() {
        val input = ",,,"
        System.setIn(input.byteInputStream())
        assertThrows<IllegalArgumentException> {
            racingGame.readyRacing()
        }
        System.setIn(System.`in`)

    }

    @Test
    fun `숫자인 이름이 한개가 포함된 예외 케이스`() {
        val input = "1,woni,jun"
        System.setIn(input.byteInputStream())
        assertThrows<IllegalArgumentException> {
            racingGame.readyRacing()
        }
        System.setIn(System.`in`)
    }

    @Test
    fun `숫자인 이름이 두개가 포함된 예외 케이스`() {
        val input = "1,2,jun"
        System.setIn(input.byteInputStream())
        assertThrows<IllegalArgumentException> {
            racingGame.readyRacing()
        }
        System.setIn(System.`in`)
    }

    @Test
    fun `숫자인 이름이 세개가 포함된 예외 케이스`() {
        val input = "1,2,3"
        System.setIn(input.byteInputStream())
        assertThrows<IllegalArgumentException> {
            racingGame.readyRacing()
        }
        System.setIn(System.`in`)
    }

    @Test
    fun `이름이 5글자를 넘는 것이 1개가 포함된 예외 케이스`() {
        val input = "pobi1,woni,jun"
        System.setIn(input.byteInputStream())
        assertThrows<IllegalArgumentException> {
            racingGame.readyRacing()
        }
        System.setIn(System.`in`)
    }

}