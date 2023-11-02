package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Util.separateNameByComma
import racingcar.util.Validator.validateLength
import racingcar.util.Validator.validateNotNull
import racingcar.util.Validator.validateUnique

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
    fun `컴마로 구분하여 리스트 반환 검증`() {
        val input = "lh99j,pobi"
        val validation = separateNameByComma(input)
        val result = listOf("lh99j", "pobi")
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `자동차 이름 길이 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateLength(listOf("pobi", "javaji")) }
            assertThrows<IllegalArgumentException> { validateLength(listOf("abcdef, abcdefg")) }

        }
    }

    @Test
    fun `자동차 이름 중복 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateUnique(listOf("pobi", "javaji", "pobi")) }
            assertThrows<IllegalArgumentException> { validateUnique(listOf("a", "b", "c", "a")) }

        }
    }

    @Test
    fun `자동차 이름 널값 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("pobi", "javaji", " ")) }
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("a", "b", "c", "")) }
            assertThrows<IllegalArgumentException> { validateNotNull(listOf("a", "b", "  ")) }
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
