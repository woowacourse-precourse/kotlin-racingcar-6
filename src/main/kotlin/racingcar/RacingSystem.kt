package racingcar

object RacingSystem {
    private var carNames:List<String> = emptyList()
    private var attemptNumber:Int = 0
    private lateinit var carLane:CarLane
    fun setCarNames(carNamesInput:String){
        var splitedCarNameInput = splitCarNameInput(carNamesInput)
        require(checkCarNameLength(splitedCarNameInput))
        carNames = splitedCarNameInput
    }

    fun setAttemptNumber(attemptNumberInput:String){
        try {
            attemptNumber = attemptNumberInput.toInt()
        }
        catch(e:NumberFormatException){
            throw IllegalArgumentException()
        }

    }

    fun createCarLane(){
        carLane = CarLane(carNames)
    }

    fun getCarNames():List<String>{
        return carNames
    }

    fun getAttemptNumber():Int{
        return attemptNumber
    }

    fun getCarLane():CarLane{
        return carLane
    }

    private fun splitCarNameInput(carNamesInput:String):List<String>{
        var result:MutableList<String> = arrayListOf()
        carNamesInput.split(',').forEach{
            result.add(it.trim())
        }
        return result
    }

    private fun checkCarNameLength(carNamesInput:List<String>):Boolean{
        carNamesInput.forEach{
            require(it.length < 6)
        }
        return true
    }

    fun presentWinner(){
        val winners = carLane.judgeWinner().joinToString(separator = ", ")
        println("\n최종 우승자 : ${winners}")
    }

    fun startAttemptCarLane(){
        for (i in 1..attemptNumber) {
            carLane.runCars()
            carLane.showLap()
        }
    }
}