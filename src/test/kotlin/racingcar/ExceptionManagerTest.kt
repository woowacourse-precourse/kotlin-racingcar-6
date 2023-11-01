package racingcar

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionManagerTest {
    private val exceptionManager = ExceptionManager()

    @Test
    fun testValidNames() {
        val validNames = listOf("fdgdf", "woni", "lee")
        assertNotNull(exceptionManager.nameException(validNames))
    }

    @Test
    fun testNameLengthException() {
        val invalidNames = listOf("pobi", "woni", "pob2124124124")
        assertThrows<IllegalArgumentException>("이름을 5자 이하로 입력해주세요") {
            exceptionManager.nameException(invalidNames)
        }
    }

    @Test
    fun testNameLastEmptyException() {
        val invalidNames = listOf("Alice", "Bob", "")
        assertThrows<IllegalArgumentException>("마지막 이름을 입력해주세요.") {
            exceptionManager.nameException(invalidNames)
        }
    }

    @Test
    fun testValidRepeatNum() {
        val validNum = "3"
        assertNotNull(exceptionManager.repeatException(validNum))
    }

    @Test
    fun testInvalidRepeatNum() {
        val invalidNum = "0"
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력해주세요") {
            exceptionManager.repeatException(invalidNum)
        }
    }

    @Test
    fun testNonNumericRepeatNum() {
        val nonNumericNum = "abc"
        assertThrows<IllegalArgumentException>("숫자를 입력해주세요.") {
            exceptionManager.repeatException(nonNumericNum)
        }
    }
    @Test
    fun testMinusNumericRepeatNum() {
        val nonNumericNum = "-1"
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력해주세요") {
            exceptionManager.repeatException(nonNumericNum)
        }
    }
}
