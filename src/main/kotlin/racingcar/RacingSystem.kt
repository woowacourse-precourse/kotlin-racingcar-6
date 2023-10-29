package racingcar

import camp.nextstep.edu.missionutils.Console

object RacingSystem {
    private var carNames:List<String> = emptyList()
    private var attemptNumber:Int = 0
    private var carLane:MutableList<Car> = arrayListOf()
    fun setCarNames(namesInput:String){
        carNames = splitNameList(namesInput)
        require(checkCarName())
    }

    fun setAttemptNumber(attemptNumberInput:String){
        try {
            attemptNumber = attemptNumberInput.toInt()
        }
        catch(e:NumberFormatException){
            throw IllegalArgumentException()
        }

    }
    fun createCars(){
        carNames.forEach{
            var car = Car(it)
            carLane.add(car)
        }
    }

    fun getCarNames():List<String>{
        return carNames
    }

    fun getAttemptNumber():Int{
        return attemptNumber
    }

    fun getCars():List<Car>{
        return carLane
    }

    private fun splitNameList(str:String):List<String>{
        var result:MutableList<String> = arrayListOf()
        str.split(',').forEach{
            result.add(it.trim())
        }
        return result
    }

    private fun checkCarName():Boolean{
        carNames.forEach{
            require(it.length < 6)
        }
        return true
    }

    fun runCars(){
        carLane.forEach{
            it.moveForward()
        }
        println()
    }

    fun showLap() {
        carLane.forEach {
            it.showDistanceWithName()
        }
    }
}