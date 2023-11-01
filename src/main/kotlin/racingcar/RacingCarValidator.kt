package racingcar

class RacingCarValidator {
    fun validateCarName(checkName: String) {
        if(checkName.isBlank() || checkName.length > 5) {
            throw IllegalArgumentException()
        }
    }
    fun checkCars(cars:String) : List<String> {
        val racingCars = cars.split(',')
        for(racingCar in racingCars){
            RacingCarValidator().validateCarName(racingCar)
        }
        return racingCars
    }
    fun checkTrying(tries: String) : Int {
        if (tries.isBlank()) {
            throw IllegalArgumentException()
        }
        try{
            return tries.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }
    companion object {
        val instance = RacingCarValidator()
    }
}