package racingcar.view

import racingcar.model.CarName
import racingcar.model.TurnNumber

interface RaceView {
    fun displayEnterCarNames()
    fun getCarNamesFromUser(): List<CarName>
    fun displayEnterTurnNumber()
    fun getTurnNumberFromUser(): TurnNumber
}