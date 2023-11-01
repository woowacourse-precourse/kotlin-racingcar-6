package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.*
import racingcar.view.RacingView


class RacingContoller {
    fun start() {
        val carNamesSeparated = carNameinput()
        val tryNum = tryNumberInput()
        validate(carNamesSeparated, tryNum)
        val carProgress = raceStart(carNamesSeparated, tryNum.toInt())
        winnerOutput(carNamesSeparated, carProgress)
        Console.close()
    }


    fun carNameinput(): List<String> {
        RacingView().carInputMassage()
        val carNames = RacingView().write()
        return CarName().separator(carNames)
    }

    fun tryNumberInput(): String {
        RacingView().tryInputMassage()
        return RacingView().write()
    }

    fun validate(carNamesSeparated: List<String>, tryNum: String) {
        Validation().carNameValidate(carNamesSeparated)
        Validation().tryNumValidate(tryNum)
    }

    fun raceStart(carNamesSeparated: List<String>, tryNum: Int): List<String> {
        RacingView().racingResult()
        var carProgress: List<String> = CarProgress().initialize(carNamesSeparated.size)
        repeat(tryNum) {
            carProgress = Game().eachRace(carProgress)
            RacingView().eachRacingResult(carNamesSeparated, carProgress)
        }
        return carProgress
    }

    fun winnerOutput(carNamesSeparated: List<String>, carProgress: List<String>) {
        val winners = Winner().discriminate(carProgress, carNamesSeparated)
        RacingView().winner(winners)
    }
}