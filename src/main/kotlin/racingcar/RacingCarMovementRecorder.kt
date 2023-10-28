package racingcar

class RacingCarMovementRecorder {
    private val racingCarGameDistancePrinter = RacingCarGameDistancePrinter()
    private val racingCarManager = RacingCarManager()
    fun racingCarMovementRecordByTryCount(cars: MutableList<RacingCar>, tryCount: Int) {
        for(i in 0 until tryCount) {
            racingCarManager.moveAllCars(cars)
            racingCarGameDistancePrinter.printAllCarsDistance(cars)
        }
    }
}