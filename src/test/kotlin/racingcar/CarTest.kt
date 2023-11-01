package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CarTest {
    @Test
    fun `차 이름이 5글자 초과인 경우`() {
        var car = Car()
        car.name = "banana"
        assertThrows<IllegalArgumentException> {
            car.isValid()
        }
    }

    @Test
    fun `split 메서드로 주어진 값을 구분`() {
        val input = "1,2"
        val result = input.split(",")
        assertThat(result).contains("2", "1")
        assertThat(result).containsExactly("1", "2")
    }

}