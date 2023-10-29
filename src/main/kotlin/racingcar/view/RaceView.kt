package racingcar.view

import racingcar.car.CarName

interface RaceView {
    fun displayEnterCarNames()
    fun getCarNamesFromUser(): List<CarName>
    fun displayEnterTurnNumber()
    fun getTurnNumberFromUser(): Int
}