package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {

    @Test
    fun `입력된 이름들이 중복될 경우 예외 케이스`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingGame().createCarsList("cop,cop") }
        }
    }

    @Test
    fun `입력된 시도 횟수가 1 이하일 경우 예외 케이스`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingGame().createAttemptsNumber("0") }
        }
    }

    @Test
    fun `입력된 시도 횟수가 숫자가 아닐 경우 예외 케이스`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { RacingGame().createAttemptsNumber("asd") }
        }
    }

}