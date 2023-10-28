package racingcar

class RacingCarMovementRecorder {
    private val racingCarGameStatePrinter = RacingCarGameStatePrinter()
    private val racingCarManager = RacingCarManager()
    fun racingCarMovementRecordByTryCount(cars: MutableList<RacingCar>, tryCount: Int) {
        for(i in 0 until tryCount) {
            racingCarManager.moveAllCars(cars)
            racingCarGameStatePrinter.printAllCarsDistance(cars)
        }
    }
}