package racingcar.Controller

import racingcar.Model.RoundState
import racingcar.Model.UserInputCheck
import racingcar.View.UserInput

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

        for (i in 1..roundInput) {
            var oneRoundResults = RoundState().oneRoundResult(carNames,raceStatus)
        }


    }
}