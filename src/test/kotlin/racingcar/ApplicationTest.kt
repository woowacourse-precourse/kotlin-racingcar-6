package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ApplicationTest : NsTest() {
    private val outputBuffer = ByteArrayOutputStream()
    private val originalOutput = System.out

    @BeforeEach
    fun setUpOutput() {
        System.setOut(PrintStream(outputBuffer))
    }

    @AfterEach
    fun restoreOutput() {
        System.setOut(originalOutput)
    }

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
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertThat(exception.message).isEqualTo("자동차 이름은 5자 이하만 가능하며, 쉼표(,)로 구분되어야 합니다.")
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
