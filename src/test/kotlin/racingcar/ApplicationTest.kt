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
    fun `자동차 이름 예외 처리`() {
        assertThrows<IllegalArgumentException>("차 이름의 길이가 5보다 큽니다.") {
            validateNameLength(listOf("pobi", "javaji"))
        }
    }

    @Test
    fun `자동차 이름 널값 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("차 이름의 길이가 5보다 큽니다.") {
                validateNull(listOf("pobi", " "))
            }

            assertThrows<IllegalArgumentException>("차 이름의 길이가 5보다 큽니다.") {
                validateNull(listOf("pobi", ""))
            }
        }
    }

    @Test
    fun `이름 문자열 배열로 변환`() {
        val input = "pobi,javaji"
        val validation = separateCarNames(input)
        val result = listOf("pobi", "javaji")
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `숫자 입력인지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("사용자의 입력이 숫자가 아닙니다.") {
                validateNumber("abc")
            }

            assertThrows<IllegalArgumentException>("사용자의 입력이 숫자가 아닙니다.") {
                validateNumber("1a")
            }

            assertThrows<IllegalArgumentException>("사용자의 입력이 숫자가 아닙니다.") {
                validateNumber("_@#!1")
            }
        }
    }

    @Test
    fun `우승자 1명 검증`() {
        val carList = listOf(Car("lh99j"), Car("pobi"))
        carList[0].moveOneStep()
        val validation = getWinner(carList).joinToString()
        val result = "lh99j"
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `우승자 여러명 검증`() {
        val carList = listOf(Car("lh99j"), Car("pobi"), Car("anjji"))
        carList[0].moveOneStep()
        carList[2].moveOneStep()
        val validation = getWinner(carList).joinToString(", ")
        val result = "lh99j, anjji"
        assertThat(validation).isEqualTo(result)
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
