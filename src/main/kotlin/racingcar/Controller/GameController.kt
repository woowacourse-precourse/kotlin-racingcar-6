package racingcar.Controller

import racingcar.View.UserInput

class GameController {

    fun gameStarter(){

        val carNameInputs=UserInput().inputCarName()
        var carNames=ErrorController().carNameErrorController(carNameInputs)

        val userRoundInput=UserInput().inputRoundNumber()
        var roundInput=ErrorController().roundNumberErrorController(userRoundInput)

        gameProgress(carNames,roundInput)
    }
    private fun gameProgress(carNames:List<String>, roundInput:Int) {

        var raceStatus = mutableMapOf<String, List<Boolean>>()

        for (i in 1..roundInput) {
            var oneRoundResults = RoundStateController().oneRoundResult(carNames)
            raceStatus= RoundStateController().placementOfScores(carNames,oneRoundResults,raceStatus)
        }
    }
}