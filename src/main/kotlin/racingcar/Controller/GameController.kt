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

        var raceStatus = mutableMapOf<String, List<Boolean>>()

        println("\n실행 결과")
        repeat (roundInput) {
            var oneRoundResults = RaceState().oneRoundResult(carNames,raceStatus)
            RaceViewer().roundResultViewer(oneRoundResults)

        }


    }
}