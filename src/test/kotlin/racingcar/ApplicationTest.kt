package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/* TestInstance : 변수가 하나의 인스턴스를 공유하여, 각각의 테스트 메소드에서 사용됨.
JUnit은 개별 테스트의 독립성 보장과 테스트 사이의 Side Effect를 최소화 하기 위해,
테스트 메소드의 실행 전 사용되는 변수에 각각 새로운 인스턴스를 생성한다.
하지만, 정적이고 불변인 데이터에 대해서 새로운 인스턴스를 생성하는 것은 메모리
낭비로 이어질 수 있으니 적절하게 TestInstance를 사용하여 메모리를 절약하고, 성능을 확보하자.

좋은 단위 테스트를 위한 FIRST 규칙
- Fast : 단위 테스트는 빨라야 한다.
- Independent : 테스트는 독립적으로 동작해야 한다. (그래야 실패 원인을 찾기 쉽다)
- Repeatable : 어떤 상황에서든 예상한 대로 테스트 결과가 나와야 한다.**
- Self-Validating : 출력 혹은 로그가 아닌 테스트 자체적으로 결과가 나와야 한다.
- Timely : 적시에 테스트를 철저하게 작성해야 한다.

given - when - then 패턴을 사용해보자.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest : NsTest() {
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

    @ParameterizedTest
    @MethodSource("RandomNumbersSingleWinner")
    @DisplayName("OutputView: printRoundResult() - Winner Single Case")
    fun `라운드 자동차 경주 점수 출력 (우승자가 한 명인 경우)`(randomNumbers: IntArray) {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains("pobi : ----", "woni : ---", "jun : ---", "최종 우승자 : pobi")
            },
            randomNumbers[0], *randomNumbers.copyOfRange(1, randomNumbers.size).toTypedArray()
        )
    }

    @ParameterizedTest
    @MethodSource("RandomNumbersMultiWinners")
    @DisplayName("OutputView: printRoundResult() - Winner Multi Case")
    fun `라운드 자동차 경주 점수 출력 (우승자가 여러 명인 경우)`(randomNumbers: IntArray) {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains("pobi : ----", "woni : ----", "jun : ---", "최종 우승자 : pobi, woni")
            },
            randomNumbers[0], *randomNumbers.copyOfRange(1, randomNumbers.size).toTypedArray()
        )
    }

    public override fun runMain() {
        main()
    }

    companion object {
        const val MOVING_FORWARD = 4
        const val STOP = 3

        @JvmStatic
        fun RandomNumbersSingleWinner() = listOf(
            intArrayOf(6, 4, 3, 8, 0, 6, 4, 7, 4, 5, 8, 5, 3, 0, 3), // 4, 3, 3
        )
        @JvmStatic
        fun RandomNumbersMultiWinners() = listOf(
            intArrayOf(6, 4, 3, 8, 0, 6, 4, 7, 4, 5, 8, 5, 3, 5, 3), // 4, 4, 3
        )
    }
}
