package racingcar.Controller

class ErrorController {

    fun carNameErrorController(inputCarNames:String):List<String>{

        var carNames=carNameSplit(inputCarNames)

        return carNames
    }

    fun roundNumberErrorController(userRoundInput: Int):Int
    {
        return userRoundInput
    }

    private fun carNameSplit(carNames: String): List<String> {

        return carNames.split(",")
    }
}