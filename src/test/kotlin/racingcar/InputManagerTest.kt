package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputManagerTest {

    @Test
    fun `입력 받은 자동차 이름의 예외 처리`() {
        val inputData = "ejlfklf, dkd".split(",")
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { ExceptionManager.carException(inputData) }
        }
    }
}