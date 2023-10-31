package racingcar.ui.viewmodel

import racingcar.data.model.toRoundStateModel
import racingcar.ui.model.RoundStateModel
import racingcar.ui.repository.RacingCarRepository
import racingcar.utils.GameUtils

class RacingCarViewModel(val repository: RacingCarRepository) {

    fun setData(cars: String, round: Int) {
        repository.setRounds(round)
        repository.setCarList(GameUtils.mappingToCarList(cars))
    }

    fun updateRounds() {
        repository.updateRoundState()
    }

    fun checkRounds(): Boolean = repository.checkRoundsEnded()

    fun getRoundState(): List<RoundStateModel> {
        return repository.getState().map {
            it.toRoundStateModel()
        }
    }

    fun findFinalWinners(): List<String> {
        return GameUtils.findWinners(repository.getState())
    }


}