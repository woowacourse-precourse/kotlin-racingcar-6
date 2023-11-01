package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import javax.swing.JOptionPane.ERROR_MESSAGE


class CarTest {
    @Test
    fun `above_four_move`(){
        // given
        var underFour = 7
        var car = Car()

        // when
        car.move(underFour)
        var result = car.count

        // then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `under_four_stop`(){
        // given
        var underFour = 3
        var car = Car()

        // when
        car.move(underFour)
        var result = car.count

        // then
        assertThat(result).isEqualTo(0)
    }


    @Test
    fun `car_name_over_five`() {
        var car = Car()
        car.name = "banana"
        assertThrows<IllegalArgumentException> {
            car.isValid()
        }
    }

}