package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TryTimeTest {

    @Test
    fun `횟수가 1회 이상이면 정상정으로 생성`() {
        Assertions.assertSimpleTest {
            assertDoesNotThrow { TryTime.createOrThrow("1") }
        }
    }

    @Test
    fun `횟수가 0회 이하면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { TryTime.createOrThrow("0") }
        }
    }

    @Test
    fun `횟수가 숫자가 아니면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { TryTime.createOrThrow("a") }
        }
    }
}