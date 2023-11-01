package racingcar

import model.Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `예외 테스트) 자동차 이름이 공백인 경우 `() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `예외 테스트) 자동차 이름의 5글자 이상일 경우`() {
        val name: String = "내이름은슈룹이야"
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }
}