package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyApplicationTest {
    @Test
    fun `addCarToList()에 대한 테스트`() {
        val input = listOf("Car1", "Car2", "Car3")
        val expected = mutableListOf<Car>(
                Car("Car1"),
                Car("Car2"),
                Car("Car3")
        )

        val actual = addCarToList(input)

        assertEquals(expected, actual)
    }

}