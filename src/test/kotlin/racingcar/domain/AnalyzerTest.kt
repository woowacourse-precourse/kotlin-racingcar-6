package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import racingcar.data.Car

class AnalyzerTest {

    private lateinit var analyzer: Analyzer

    @BeforeEach
    fun setUp() {
        analyzer = Analyzer()
    }

    @Test
    fun `숫자 0이 나오면 움직일 수 없다는 의미의 false를 반환한다`() {
        // given
        val pickedNum = 0

        // when
        val actual = analyzer.isMoveAllowed(pickedNum)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }


    @Test
    fun `숫자 3이 나오면 움직일 수 없다는 의미의 false를 반환한다`() {
        // given
        val pickedNum = 3

        // when
        val actual = analyzer.isMoveAllowed(pickedNum)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 4가 나오면 움직일 수 있다는 의미의 true를 반환한다`() {
        // given
        val pickedNum = 4

        // when
        val actual = analyzer.isMoveAllowed(pickedNum)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 9가 나오면 움직일 수 있다는 의미의 true를 반환한다`() {
        // given
        val pickedNum = 9

        // when
        val actual = analyzer.isMoveAllowed(pickedNum)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `3칸 전진한 A, 2칸 전진한 B, 0칸 전진한 C를 입력하면 A를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(3) {
            a.move()
        }
        val b = Car("B")
        repeat(2) {
            b.move()
        }
        val c = Car("C")
        val candidates = listOf(a, b, c)

        // when
        val actual = analyzer.judgeWinner(candidates)

        // then
        val expected = listOf(a)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 3칸 전진한 B, 2칸 전진한 C를 입력하면 B를 승자로 반환한다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        repeat(3) {
            b.move()
        }
        val c = Car("C")
        repeat(2) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = analyzer.judgeWinner(candidates)

        // then
        val expected = listOf(b)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 3칸 전진한 C를 입력하면 C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(3) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = analyzer.judgeWinner(candidates)

        // then
        val expected = listOf(c)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 2칸 전진한 C를 입력하면 A, C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(2) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = analyzer.judgeWinner(candidates)

        // then
        val expected = listOf(a, c)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 0칸 전진한 B, 0칸 전진한 C를 입력하면 A, B, C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val c = Car("C")
        val candidates = listOf(a, b, c)

        // when
        val actual = analyzer.judgeWinner(candidates)

        // then
        val expected = listOf(a, b, c)
        assertThat(actual).isEqualTo(expected)
    }
}