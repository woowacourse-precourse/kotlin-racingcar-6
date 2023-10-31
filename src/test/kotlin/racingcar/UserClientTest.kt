package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class UserClientTest {

    @Test
    fun `inputRoundCount() 숫자에 문자열 표함`() {
        assertThrows<IllegalArgumentException>("잘못된 입력") {
            userClient.checkIsNumber("12n")
        }
    }

    @Test
    fun `inputRoundCount() 공백입력`() {
        assertThrows<IllegalArgumentException>("잘못된 입력") {
            userClient.checkIsNumber("")
        }
    }

    @Test
    fun `inputRoundCount() 정상입력`() {
        assertDoesNotThrow {
            userClient.checkIsNumber("124")
        }
    }


    @Test
    fun `자동차 이름 5글자 초과`() {
        assertThrows<IllegalArgumentException>("잘못된 입력") {
            userClient.afterCheckConvertCarList("fiveOver,abc,de")
        }
    }

    @Test
    fun `자동차 이름 공백입력`() {
        assertThrows<IllegalArgumentException>("자동차 개수 0 또는 1개 입력") {
            userClient.afterCheckConvertCarList("")
        }
    }
    @Test
    fun `자동차 이름 사이 공백 입력`() {
        assertThrows<IllegalArgumentException>("자동차 이름 공백") {
            userClient.afterCheckConvertCarList("abc,,def")
        }
    }
    @Test
    fun `자동차 이름 한 개만 입력`() {
        assertThrows<IllegalArgumentException>("자동차 개수 0 또는 1개 입력") {
            userClient.afterCheckConvertCarList("five")
        }
    }


    @Test
    fun `쉼표기준 맨앞 쉼표`() {
        assertThrows<IllegalArgumentException>("맨앞 쉼표") {
            userClient.afterCheckConvertCarList(",asd,sdf")
        }
    }

    @Test
    fun `쉼표기준 맨뒤 쉼표`() {
        assertThrows<IllegalArgumentException>("맨뒤 쉼표") {
            userClient.afterCheckConvertCarList("asd,sdfd,sdsf,sddd,")
        }
    }

    @Test
    fun `쉼표기준 정상입력`() {
        assertEquals(
            userClient.afterCheckConvertCarList("abc,def,ghi").map{it.name},
            listOf(Car("abc"), Car("def"), Car("ghi")).map{it.name}
        )
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