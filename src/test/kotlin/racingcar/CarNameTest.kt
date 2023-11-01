package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameTest : NsTest() {
    @Test
    fun `자동차 이름이 없을 때`() {
        assertThrows<IllegalArgumentException> { runException(",java", "1") }
    }

    @Test
    fun `자동차 이름에 공백이 있을 때`() {
        assertThrows<IllegalArgumentException> { runException("a a,java", "1") }
    }

    override fun runMain() {
        main()
    }
}