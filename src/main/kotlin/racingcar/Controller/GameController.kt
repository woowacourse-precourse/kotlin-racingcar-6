package racingcar.Controller

import racingcar.Model.RaceState
import racingcar.Model.UserInputCheck
import racingcar.View.UserInput
import racingcar.View.RaceViewer

class GameController {

    fun gameStarter(){

        val carNameInputs=UserInput().inputCarName()
        var carNames= UserInputCheck().carNameErrorController(carNameInputs)

        val userRoundInput=UserInput().inputRoundNumber()
        var roundInput= UserInputCheck().roundNumberErrorController(userRoundInput)

        gameProgress(carNames,roundInput)
    }
    private fun gameProgress(carNames:List<String>, roundInput:Int) {

        var entireRaceStatus = mutableMapOf<String, List<Boolean>>()
        var oneRoundResults: List<Boolean>
        val raceWinner:List<String>

        println("\n실행 결과")
        repeat (roundInput) {
            oneRoundResults = RaceState().oneRoundResult(carNames)
            entireRaceStatus=RaceState().updateEntireRaceScore(carNames,oneRoundResults,entireRaceStatus)
            RaceViewer().roundResultViewer(entireRaceStatus)
        }

        raceWinner=RaceState().raceWinnerSelect(entireRaceStatus)
        RaceViewer().winnerViewer(raceWinner)

    }
}