package racingcar.controller

class RoundManagement(val count:Int,val racingCarsManagement: RacingCarsManagement) {

    fun playRound(){
        racingCarsManagement.cars.forEach { racingCarModel -> racingCarModel.tryToMove() }
    }

    fun getRacingResult():String{
        var result = ""
        racingCarsManagement.cars.forEach {racingCarModel ->
            val movementResult = "-".repeat(racingCarModel.place)
            result += "${racingCarModel.name} : $movementResult \n"
        }
        return result
    }

}