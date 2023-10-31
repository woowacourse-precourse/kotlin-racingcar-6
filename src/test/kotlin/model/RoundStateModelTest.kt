package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.ui.model.RoundStateModel

class RoundStateModelTest {
    @Test
    fun `RoundStateModel properties 확인`() {
        // Arrange
        val roundStateModel = RoundStateModel("car1", "----")

        // Assert
        Assertions.assertThat(roundStateModel.carName).isEqualTo("car1")
        Assertions.assertThat(roundStateModel.moveState).isEqualTo("----")
    }
}