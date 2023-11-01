package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `5자 이상 입력된 차의 이름 검사`() {
        val input = "mountain"
        assertThrows<IllegalArgumentException> { Car(input) }
    }

    @Test
    fun `1자 이상 5자 이하 이지만 이름이 공백인 경우`() {
        val input = " "
        assertThrows<IllegalArgumentException> { Car(input) }
    }

    @Test
    fun `이름이 입력되지 않은 경우`() {

    }

}