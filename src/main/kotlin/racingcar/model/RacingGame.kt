package racingcar.model

class RacingGame {
    fun racing(cars: List<Int>): MutableList<Int> {
        var carProgress: MutableList<Int> = mutableListOf()
        for (car in cars) {
            if (RandomNumberGenerator().Generator() > Constants.FOUR) {
                carProgress.add(car + 1)
            } else {
                carProgress.add(car)
            }
        }
        return carProgress
    }
}