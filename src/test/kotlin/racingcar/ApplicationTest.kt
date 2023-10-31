package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

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

    public override fun runMain() {
        main()
    }

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
        Assertions.assertEquals(
            userClient.afterCheckConvertCarList("abc,def,ghi").map { it.name },
            listOf(Car("abc"), Car("def"), Car("ghi")).map { it.name }
        )
    }


    companion object {
        var userClient = UserClient()

        private const val MOVING_FORWARD = 4
        private const val STOP = 3
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            userClient = UserClient()
        }
    }
}
