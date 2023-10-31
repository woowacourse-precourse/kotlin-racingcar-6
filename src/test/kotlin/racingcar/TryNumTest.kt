package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryNumTest:NsTest() {
    @Test
    fun `시도 횟수가 숫자가 아닐 때`() {
        assertThrows<IllegalStateException> { runException("jina,java", "ada") }
    }

    override fun runMain() {
        main()
    }
}