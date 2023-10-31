package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryNumTest:NsTest() {
    @Test
    fun `시도 횟수가 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> { runException("jina,java", "a") }
    }

    override fun runMain() {
        main()
    }
}