package repository

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.data.RacingCarModel
import racingcar.data.RacingCarRepositoryImpl
import racingcar.ui.repository.RacingCarRepository

class RacingCarRepositoryImplTest {
    private val racingCarRepository: RacingCarRepository = RacingCarRepositoryImpl()

    @Test
    fun `setRounds 메서드로 라운드 설정 후 checkRemainingRounds 메서드로 라운드 확인`() {
        // Arrange
        val rounds = 5

        // Act
        racingCarRepository.setRounds(rounds)

        // Assert
        Assertions.assertThat(racingCarRepository.checkRoundsEnded()).isTrue()
    }

    @Test
    fun `setCarList 메서드로 List 설정 후 getState 메서드로 List size 확인`() {
        // Arrange
        val carList = listOf(RacingCarModel("car1", 0), RacingCarModel("car2", 0))

        // Act
        racingCarRepository.setCarList(carList)

        // Assert
        Assertions.assertThat(racingCarRepository.getState()).hasSize(2)
    }

    @Test
    fun `updateRoundState 메서드 호출 후 남은 라운드 확인`() {
        // Arrange
        val carList = listOf(RacingCarModel("car1", 0), RacingCarModel("car2", 0))
        racingCarRepository.setRounds(2)
        racingCarRepository.setCarList(carList)

        // Act
        racingCarRepository.updateRoundState()

        // Assert
        Assertions.assertThat(racingCarRepository.checkRoundsEnded()).isFalse()

        // Act
        racingCarRepository.updateRoundState()

        // Assert
        Assertions.assertThat(racingCarRepository.checkRoundsEnded()).isTrue()
    }
}