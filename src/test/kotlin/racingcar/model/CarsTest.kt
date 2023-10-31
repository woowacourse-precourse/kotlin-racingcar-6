package racingcar.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarsTest {
    private lateinit var cars: Cars

    @Test
    fun `중복된 이름이 있으면 예외를 던진다`() {
        cars = Cars(listOf(Car("pobi"), Car("woni"), Car("jun"), Car("pobi")))
        assertThrows<IllegalArgumentException>(
            "차에 중복된 이름이 있습니다."
        ) {
            cars.validateDuplicate()
        }
    }

    @Test
    fun `중복된 이름이 없으면 테스트를 통과한다`() {
        cars = Cars(listOf(Car("pobi"), Car("woni"), Car("jun")))
        assertDoesNotThrow { cars.validateDuplicate() }
    }

}