package racingcar.view

import racingcar.model.CarName

interface RaceView {
    fun displayEnterCarNames()
    fun getCarNamesFromUser(): List<CarName>
    fun displayEnterTurnNumber()
    fun getTurnNumberFromUser(): Int
}