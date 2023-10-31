package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.CarNameSeparator

class FunctionTest {
    @Test
    fun testSeparator() {
        val names = "kim,su,han,mu"
        val result = CarNameSeparator().separator(names)
        val expectedList = listOf("kim","su","han","mu")
        assertEquals(expectedList, result)
    }
}