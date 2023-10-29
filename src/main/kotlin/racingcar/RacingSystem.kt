package racingcar

import camp.nextstep.edu.missionutils.Console

object RacingSystem {
    private var carNames:List<String> = emptyList()
    private var attemptNumber:Int = 0
    private var carLane:MutableList<Car> = arrayListOf()
    fun setCarNames(namesInput:String){
        carNames = splitNameList(namesInput)
    }
    fun setAttemptNumber(attemptNumberInput:String){
        try {
            attemptNumber = attemptNumberInput.toInt()
        }
        catch(e:NumberFormatException){
            throw IllegalArgumentException()
        }

    }

    fun getCarNames():List<String>{
        return carNames
    }

    fun getAttemptNumber():Int{
        return attemptNumber
    }

    private fun splitNameList(str:String):List<String>{
        var result:MutableList<String> = arrayListOf()
        str.split(',').forEach{
            result.add(it.trim())
        }
        return result
    }

    private fun checkCarName(nameList:List<String>):Boolean{
        nameList.forEach{
            require(it.length < 6)
        }
        return true
    }

    fun createCars(){
        require(checkCarName(carNames))
        carNames.forEach{
            var car = Car(it)
            carLane.add(car)
        }
    }





}