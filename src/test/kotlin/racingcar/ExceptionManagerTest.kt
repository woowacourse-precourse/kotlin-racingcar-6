package racingcar

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionManagerTest {
    private val exceptionManager = ExceptionManager()

    @Test
    fun `정상적인 입력을 하였을 때`() {
        val validNames = listOf("fdgdf", "woni", "lee")
        assertNotNull(exceptionManager.nameException(validNames))
    }

    @Test
    fun `이름을 5자 이상 입력했을때 예외처리`() {
        val invalidNames = listOf("pobi", "woni", "pob2124124124")
        assertThrows<IllegalArgumentException>("이름을 5자 이하로 입력해주세요") {
            exceptionManager.nameException(invalidNames)
        }
    }

    @Test
    fun `마지막 이름을 (,)뒤에 입력하지 않았을 때`() {
        val invalidNames = listOf("Alice", "Bob", "")
        assertThrows<IllegalArgumentException>("마지막 이름을 입력해주세요.") {
            exceptionManager.nameException(invalidNames)
        }
    }

    @Test
    fun `정상적인 값 입력시`() {
        val validNum = "3"
        assertNotNull(exceptionManager.repeatException(validNum))
    }

    @Test
    fun `1이상의 숫자를 입력하지 않았을 때 예외처리`() {
        val invalidNum = "0"
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력해주세요") {
            exceptionManager.repeatException(invalidNum)
        }
    }

    @Test
    fun `숫자대신 문자를 입력했을 때 예외처리`() {
        val nonNumericNum = "abc"
        assertThrows<IllegalArgumentException>("숫자를 입력해주세요.") {
            exceptionManager.repeatException(nonNumericNum)
        }
    }
    @Test
    fun `음수를 입력했을 때 예외처리`() {
        val nonNumericNum = "-1"
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력해주세요") {
            exceptionManager.repeatException(nonNumericNum)
        }
    }
}
