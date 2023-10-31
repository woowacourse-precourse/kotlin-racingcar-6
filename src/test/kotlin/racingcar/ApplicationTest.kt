package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Nested
    @DisplayName("자동차 입력 테스트")
    inner class CarNameInputTest{
        @Test
        fun `이름 5글자 초과에 대한 예외 처리`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            }
        }

        @Test
        fun `중복 이름에 대한 예외 처리`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1", "!@#", "Audi"])
        fun `영어 소문자가 아닌 이름에 대한 예외 처리`(carName: String) {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException(carName, "1") }
            }
        }
    }

    @Nested
    @DisplayName("자동차 입력 테스트")
    inner class AmountInputTest(){
        @ParameterizedTest
        @ValueSource(strings = ["12a", "!@#", "a","-1","0"," "])
        fun `자연수가 아닌 횟수에 대한 예외 처리`(amount: String) {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,arg", amount) }
            }
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
