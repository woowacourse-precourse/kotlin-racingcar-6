package racingcar.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.car.CarName

class CarNameTest {
    @Test
    fun createCarName_lengthIsLongerThan5_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException::class.java) {
            CarName(CAR_NAME_LENGTH_LONGER_THAN_5)
        }
    }

    @Test
    fun createCarName_emptyName_successfullyCreated() {
        val carname = CarName(CAR_NAME_EMPTY)
        assertThat(carname.name).isEqualTo(CAR_NAME_EMPTY)
    }

    @Test
    fun createCarName_lengthIs5_successfullyCreated() {
        val carname = CarName(CAR_NAME_LENGTH_5)
        assertThat(carname.name).isEqualTo(CAR_NAME_LENGTH_5)
    }

    companion object {
        private const val CAR_NAME_LENGTH_LONGER_THAN_5 = "ABCDEF"
        private const val CAR_NAME_EMPTY = ""
        private const val CAR_NAME_LENGTH_5 = "12345"
    }
}