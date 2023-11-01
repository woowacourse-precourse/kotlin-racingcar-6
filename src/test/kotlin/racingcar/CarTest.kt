package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CarTest {
    var car = Car("pobi")
    var cars = mutableListOf<Car>()
    @Test
    fun testThrowExceptionOverFive() {
        assertThrows<IllegalArgumentException> {
            throwExceptionOverFive("Ronaldinho")
        }
    }

}