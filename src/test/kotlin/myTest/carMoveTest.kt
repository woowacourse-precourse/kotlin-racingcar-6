package myTest

import camp.nextstep.edu.missionutils.Randoms
import io.mockk.every
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.RacingGame


class carMoveTest {
    @BeforeEach
    fun setUp() {
        mockkStatic("camp.nextstep.edu.missionutils.Randoms")
    }

    @Test
    fun `4보다 큰거나 같은 값일 때 움직이는지 확인`() {
        for (i in 4..9) {
            every { Randoms.pickNumberInRange(0, 9) } returns i

            val racingGame = RacingGame(emptyList(), 0)
            val result = racingGame.isCarMove()

            assertThat(result).isTrue()
        }
    }

    @Test
    fun `4보다 작은 값일 때 움직이지 않는지 확인`() {
        for (i in 0..3) {
            every { Randoms.pickNumberInRange(0, 9) } returns i

            val racingGame = RacingGame(emptyList(), 0)
            val result = racingGame.isCarMove()

            assertThat(result).isFalse()
        }
    }

    @Test
    fun `한 라운드를 진행했을때 최고 이동거리가 1인지 확인`() {

        val carList = listOf("test1", "test2", "test3")
        val racingTime = 1

        val racingGame = RacingGame(carList, 1)
        every { Randoms.pickNumberInRange(0, 9) } returns 5
//        every { racingGame.isCarMove() } returns false

        val winnerPos = racingGame.onRoundPlay()

        assertThat(winnerPos).isEqualTo(1)

    }

    @Test
    fun `다섯 라운드를 진행했을때 최고 이동거리가 5인지 확인`() {

        val carList = listOf("test1", "test2", "test3")
        val racingTime = 1
        var winnerPos: Int = 0

        val racingGame = RacingGame(carList, 5)
        every { Randoms.pickNumberInRange(0, 9) } returns 5
//        every { racingGame.isCarMove() } returns false

        for (i in 0..4) {
            winnerPos = racingGame.onRoundPlay()
        }

        assertThat(winnerPos).isEqualTo(5)

    }
}