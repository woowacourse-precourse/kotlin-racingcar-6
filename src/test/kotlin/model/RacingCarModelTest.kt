package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.data.model.RacingCarModel
import racingcar.data.model.toRoundStateModel

class RacingCarModelTest {
    @Test
    fun `RacingCarModel properties 확인`() {
        // Arrange
        val racingCarModel = RacingCarModel("car1", 3)

        // Assert
        Assertions.assertThat(racingCarModel.carName).isEqualTo("car1")
        Assertions.assertThat(racingCarModel.moveForward).isEqualTo(3)
    }
    @Test
    fun `toRoundStateModel 매핑 확인`() {
        // Arrange
        val racingCarModel = RacingCarModel("car1", 3)

        // Act
        val roundStateModel = racingCarModel.toRoundStateModel()

        // Assert
        Assertions.assertThat(roundStateModel.carName).isEqualTo("car1")
        Assertions.assertThat(roundStateModel.moveState).isEqualTo("---")
    }
}