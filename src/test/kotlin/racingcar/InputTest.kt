package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest: NsTest() {
    @Test
    fun `5자 이상인 이름에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            run(nameOverFiveChar)
        }
    }
    @Test
    fun `이동 횟수에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            run("jm,jmt", countButString)
        }
    }
    public override fun runMain() {
        main()
    }
    companion object {
        private const val nameOverFiveChar = "jeongmin"
        private const val countButString = "qwer"
    }
}