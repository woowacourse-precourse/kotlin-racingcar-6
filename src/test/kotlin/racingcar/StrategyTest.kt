package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.movestrategy.BasicMoveStrategy
import racingcar.domain.movestrategy.TestMoveStrategy

class StrategyTest {
    @Test
    fun `기본 전략에서 정지와 전진이 잘 나타나는가`() {
        val strategy = BasicMoveStrategy()
        val result = mutableListOf<Int>()
        for (i in 1..50) {
            result.add(strategy.calculateLocation(1, 0))
        }

        assertThat(result).contains(1, 0)
    }

    @Test
    fun `기본 전략에서 현재 위치에 따른 움직임이 바른가`() {
        val strategy = BasicMoveStrategy()
        val result = mutableListOf<Int>()
        for (i in 1..50) {
            result.add(strategy.calculateLocation(1, 4))
        }

        assertThat(result).contains(4, 5)
    }

    @Test
    fun `기본 전략에서 속도에 따른 움직임이 바른가 `() {
        val strategy = BasicMoveStrategy()
        val result = mutableListOf<Int>()
        for (i in 1..50) {
            result.add(strategy.calculateLocation(2, 0))
        }

        assertThat(result).contains(2, 0).doesNotContain(1)
    }

    @Test
    fun `테스트 전략에서 입력값(랜덤, 위치)에 따른 움직임이 바른가`() {
        val strategy = TestMoveStrategy(listOf(4, 3, 5, 2))
        val expect = listOf(0, 1, 1, 2, 2)
        val result = mutableListOf<Int>(0)
        for (i in 1..4) {
            result.add(strategy.calculateLocation(1, result[result.lastIndex]))
        }

        assertThat(result).isEqualTo(expect)
    }


}