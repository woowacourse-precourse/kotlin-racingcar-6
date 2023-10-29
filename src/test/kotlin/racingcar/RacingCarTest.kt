package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingCarTest {

    @Test
    fun `이름이 5자 이하면 정상정으로 생성`() {
        assertSimpleTest {
            assertDoesNotThrow { RacingCar.createOrThrow("hello") }
        }
    }

    @Test
    fun `이름이 5자 초과면 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingCar.createOrThrow("wonder") }
        }
    }
}