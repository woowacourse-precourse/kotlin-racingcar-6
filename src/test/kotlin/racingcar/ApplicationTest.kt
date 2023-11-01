package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    val car = Car()
    val racing = Racing()

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
    fun `이름이 다섯글자 이상인 경우 예외처리`() {
        assertSimpleTest {
            val carNames = listOf("qwer", "tyuiop", "asdf")
            assertThrows<IllegalArgumentException> { car.validateCarNameLength(carNames) }
        }
    }


    @Test
    fun `이름이 중복인 경우 예외처리`() {
        assertSimpleTest {
            val carNames = listOf("qwer", "qwer", "tyu", "iop")
            assertThrows<IllegalArgumentException> { car.validateDuplicateName(carNames) }
        }
    }


    @Test
    fun `이름이 공백인 경우 예외처리`() {
        assertSimpleTest {
            val carNames = listOf("qwer"," ","tyu","iop")
            assertThrows<IllegalArgumentException> { car.validateBlankName(carNames) }
        }
    }

    @Test
    fun `이름이 공백이 포함된 경우 예외처리`() {
        assertSimpleTest {
            val carNames = listOf("qwer","a "," b","iop")
            assertThrows<IllegalArgumentException> { car.validateNameHaveBlank(carNames) }
        }
    }
    @Test
    fun `이동 횟수가 0일 경우 예외처리`() {
        assertSimpleTest {
            val moveCount = listOf(0,3,6,9)
            assertThrows<IllegalArgumentException>  { moveCount.forEach{ racing.validatePositiveInteger(it) } }
        }
    }

    @Test
    fun `이동 횟수가 정수가 아닐 경우 예외 처리`() {
        assertSimpleTest {
            val moveCount = listOf("ㅇ","2","","a","2.5")
            assertThrows<IllegalArgumentException>  { moveCount.forEach{ racing.validateInteger(it) } }
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
