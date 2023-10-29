package racingcar.model

class RacingGame {
    fun racing(cars: List<String>): List<String> {
        var carProgress = mutableListOf<String>()
        for (car in cars) {
            if (RandomNumberGenerator().Generator() >= Constants.FOUR) {
                carProgress.add(car + Constants.DASH.toString())
            } else {
                carProgress.add(car)
            }
        }
        return carProgress
    }
}