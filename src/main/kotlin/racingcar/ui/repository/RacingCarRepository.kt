package racingcar.ui.repository

import racingcar.data.RacingCarModel

interface RacingCarRepository {
    fun setRounds(round : Int)
    fun setCarList(list : List<RacingCarModel>)
    fun updateRoundState()
    fun checkRemainingRounds() : Boolean
}