package racingcar.controller

class RoundManagement(val roundCount:Int,val racingCarsManagement: RacingCarsManagement) {

    fun playRound(){
        racingCarsManagement.cars.forEach { racingCarModel -> racingCarModel.tryToMove() }
    }

}