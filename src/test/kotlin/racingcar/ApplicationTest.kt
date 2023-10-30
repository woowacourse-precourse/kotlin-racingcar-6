package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Repetition
import racingcar.view.InputView

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

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
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
