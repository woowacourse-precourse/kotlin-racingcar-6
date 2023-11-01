package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CarTest {
//    @Test
//    fun `above_four_move`(){
//        // given
//        var underFour = 7
//        var car = Car()
//
//        // when
//        car.move(underFour)
//        var result = car.count
//
//        // then
//        assertThat(result).isEqualTo(1)
//    }
//
//    @Test
//    fun `under_four_stop`(){
//        // given
//        var underFour = 3
//        var car = Car()
//
//        // when
//        car.move(underFour)
//        var result = car.count
//
//        // then
//        assertThat(result).isEqualTo(0)
//    }


    @Test
    fun `car_name_over_five`() {
        var car = Car()
        car.name = "banana"
        assertThrows<IllegalArgumentException> {
            car.isValid()
        }
    }

}