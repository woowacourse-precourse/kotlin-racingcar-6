package util
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.data.model.RacingCarModel
import racingcar.utils.GameUtils

class GameUtilsTest {
    @Test
    fun `updateCarsState 메소드 실행 후 각 자동차가 전진 or 정지 하였는지 확인`() {
        // Arrange
        val carList = listOf(RacingCarModel("car1", 0), RacingCarModel("car2", 0), RacingCarModel("car3", 0))

        // Act
        val updatedCars = GameUtils.updateCarsState(carList)

        // Assert
        assertThat(updatedCars).isNotEmpty()
        assertThat(updatedCars).allMatch { it.moveForward in 0..1 }
    }

    @Test
    fun `checkRoundEnded 메서드가 남은 라운드가 0일 경우 true return`() {
        // Arrange
        val isRoundEnded = 0

        // Act
        val result = GameUtils.checkRoundEnded(isRoundEnded)

        // Assert
        assertThat(result).isTrue()
    }

    @Test
    fun `checkRoundEnde 메서드가 아직 라운드가 끝나지 않았을 경우 false return`() {
        // Arrange
        val isRoundEnded = 5

        // Act
        val result = GameUtils.checkRoundEnded(isRoundEnded)

        // Assert
        assertThat(result).isFalse()
    }

    @Test
    fun `findWinners 메소드가 우승자를 정확하게 맞추는지 확인`() {
        // Arrange
        val carList = listOf(
            RacingCarModel("car1", 3),
            RacingCarModel("car2", 5),
            RacingCarModel("car3", 5),
            RacingCarModel("car4", 2)
        )

        // Act
        val winners = GameUtils.findWinners(carList)

        // Assert
        assertThat(winners).containsExactly("car2", "car3")
    }

    @Test
    fun `mappingToCarList 메서드로 주어진 값을 구분`() {
        // Arrange
        val input = "car1,car2,car3"

        // Act
        val carList = GameUtils.mappingToCarList(input)

        // Assert
        assertThat(carList).hasSize(3)
        assertThat(carList.map { it.carName }).containsExactly("car1", "car2", "car3")
        assertThat(carList.map { it.moveForward }).allMatch { it == 0 }
    }
}
