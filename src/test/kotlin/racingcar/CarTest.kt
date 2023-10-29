package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CarTest {

    @Test
    fun testToString() {
        val car = Car("pobi", 4)
        assertEquals("pobi : ----", car.toString())
    }
}