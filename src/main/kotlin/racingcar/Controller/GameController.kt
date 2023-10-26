package racingcar.Controller

import racingcar.View.UserInput

class GameController {

    fun gameStarter(){

        val carNameInputs=UserInput().inputCarName()
        var carNames=ErrorController().carNameErrorController(carNameInputs)

        val userRoundInput=UserInput().inputRoundNumber()
        var roundInput=ErrorController().roundNumberErrorController(userRoundInput)

    }
}