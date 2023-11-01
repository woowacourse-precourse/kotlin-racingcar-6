package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.*
import racingcar.view.Input
import racingcar.view.Output

class GameManager {
    fun start() {
        val carNamesSeparated = carNameinput()
        val tryNum = tryNumberInput()
        validate(carNamesSeparated, tryNum)
        val carProgress = race(carNamesSeparated, tryNum.toInt())
        winnerOutput(carNamesSeparated, carProgress)
        Console.close()
    }


    fun carNameinput(): List<String> {
        Output().carInputMassage()
        val carNames = Input().write()
        return CarName().separator(carNames)
    }

    fun tryNumberInput(): String {
        Output().tryInputMassage()
        return Input().write()
    }

    fun validate(carNamesSeparated: List<String>, tryNum: String) {
        Validation().carNameValidate(carNamesSeparated)
        Validation().tryNumValidate(tryNum)
    }

    fun race(carNamesSeparated: List<String>, tryNum: Int): List<String> {
        Output().racingResult()
        var carProgress: List<String> = CarProgress().initialize(carNamesSeparated.size)
        repeat(tryNum) {
            carProgress = Game().eachRace(carProgress)
            Output().eachRacingResult(carNamesSeparated, carProgress)
        }
        return carProgress
    }

    fun winnerOutput(carNamesSeparated: List<String>, carProgress: List<String>) {
        val winners = Winner().discriminate(carProgress, carNamesSeparated)
        Output().winner(winners)
    }
}