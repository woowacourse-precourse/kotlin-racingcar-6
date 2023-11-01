package racingcar.model

class Game {
    fun eachRace(cars: List<String>): List<String> {
        var carProgress = mutableListOf<String>()
        for (car in cars) {
            if (RandomNumber().generator() >= Constants.FOUR) {
                carProgress.add(car + Constants.DASH.toString())
                continue
            }
            carProgress.add(car)
        }
        return carProgress
    }
}