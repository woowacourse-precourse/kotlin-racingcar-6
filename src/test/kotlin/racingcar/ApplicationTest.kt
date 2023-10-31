package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `자동차 이름 입력의 첫 입력이 줄바꿈(엔터)인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    @Test
    fun `자동차 입력의 시작과 끝이 콤마(,)인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(",pobi,javaji", "pobi,javaji,")
            }
        }
    }

    @Test
    fun `자동차 이름의 길이가 5이상인 경우`() {
        val carNamesList: List<String> = listOf("poby", "jiwon", "java","kotlin")
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                carNamesList.forEach { carNames ->
                    if(carNames.length >= CAR_NAME_MAX_LENGTH) throw IllegalArgumentException()
                }
            }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외 처리`() {
        val attemptCount: String = "ONE"
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                if(attemptCount.toIntOrNull() == null) throw IllegalArgumentException()
            }
        }
    }

    @Test
    fun `우승자 한 명 초과일 때, 쉼표 출력`() {
        val winners: String = listOf("poby", "popo").joinToString(", ")
        assertThat(winners).isEqualTo("poby, popo")
    }

    @Test
    fun `우승자가 한 명인 경우`() {
        val winner: String = listOf("poby").joinToString("")
        assertThat(winner).isEqualTo("poby")
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3

        private const val CAR_NAME_MAX_LENGTH = 5
    }
}
