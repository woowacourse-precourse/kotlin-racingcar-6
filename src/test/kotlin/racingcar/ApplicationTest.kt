package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    private val cars: List<Car> = listOf(Car("A", 0), Car("B", 0), Car("C", 0))
    private val racing: Racing = Racing(cars)

    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름 중복에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("abc", "abc", "aa", "bb")
            assertThrows<IllegalArgumentException> { isCarNameUnique(carNames) }
        }
    }

    @Test
    fun `이름 길이에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("hello", "sponge", "bob", "haha")
            assertThrows<IllegalArgumentException> {
                carNames.forEach { isCarNameLengthValid(it) }
            }
        }
    }

    @Test
    fun `이름 공백에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("hello", " ", "", "hey")
            assertThrows<IllegalArgumentException> {
                carNames.forEach { isCarNameNotEmpty(it) }
            }
        }
    }

    @Test
    fun `시도 횟수 입력에 대한 예외 처리`() {
        assertSimpleTest {
            val attempts = listOf("0", "", "2", "10", "a", "ㄱ")
            assertThrows<IllegalArgumentException> {
                attempts.forEach { isNumberAttemptsValid(it) }
            }
        }
    }

    @Test
    fun `전진 정지 판단`() {
        assertSimpleTest {
            val randomNumbers = listOf(1, 5, 4, 2, 6)
            val results: MutableList<Boolean> = MutableList<Boolean>(5) { false }
            randomNumbers.forEachIndexed { idx, i -> results[idx] = racing.determineMoveOrStop(i) }
            assertThat(results).isEqualTo(listOf(false, true, true, false, true))
        }
    }

    public override fun runMain() {
        main()
    }


    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
