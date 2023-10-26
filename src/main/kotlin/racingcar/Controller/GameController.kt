package racingcar.Controller

import racingcar.View.UserInput

class GameController {

    fun gameStarter(){

        var carNameInputs=UserInput().inputCarName()

        var userRoundInput=UserInput().inputRoundNumber().toInt()

        var carNames=ErrorController().carNameErrorController(carNameInputs)
        var roundInput=ErrorController().roundNumberErrorController(userRoundInput)

    }
}