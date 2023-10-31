package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class UserClientTest {

    @Test
    fun `inputRoundCount() 숫자에 문자열 표함`() {
        assertThrows<IllegalArgumentException>("잘못된 입력"){
            userClient.checkIsNumber("12n")
        }
    }

    @Test
    fun `inputRoundCount() 공백입력`() {
        assertThrows<IllegalArgumentException>("잘못된 입력"){
            userClient.checkIsNumber("")
        }
    }

    @Test
    fun `inputRoundCount() 정상입력`() {
        assertDoesNotThrow{
            userClient.checkIsNumber("124")
        }
    }

    @Test
    fun checkUnderFiveCharRegex() {
    }

    @Test
    fun checkContainRestPoint() {
    }

    @Test
    fun printResult() {
    }

    companion object {
        var userClient = UserClient()
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
           userClient = UserClient()
        }
    }
}