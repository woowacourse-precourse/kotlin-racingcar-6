package racingcar.model

class RoundModel(val number:Int,val racingCars:MutableList<RacingCarModel>) {

    fun getRacingResult():String{
        var result = ""
        racingCars.forEach {racingCarModel ->
            val movementResult = "-".repeat(racingCarModel.place)
            result += "${racingCarModel.name} : $movementResult \n"
        }
        return result
    }

}