package racingcar.ui.viewmodel

import racingcar.data.RacingCarModel
import racingcar.ui.repository.RacingCarRepository
import racingcar.util.GameUtils

class RacingCarViewModel(val repository: RacingCarRepository) {

    fun setData(cars : String, round :Int){
        repository.setRounds(round)
        repository.setCarList(GameUtils.mappingToCarList(cars))
    }

}