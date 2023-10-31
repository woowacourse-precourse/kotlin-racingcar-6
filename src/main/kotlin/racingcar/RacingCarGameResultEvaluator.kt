package racingcar

class RacingCarGameResultEvaluator {
    fun racingCarGameJudge(cars: List<RacingCar>) : List<String> {
        val winners = mutableListOf<String>()
        var max = Int.MIN_VALUE
        for(car in cars) {
            max = max.coerceAtLeast(car.distance)
        }
        for(car in cars) {
            if(car.distance == max) {
                winners.add(car.name)
            }
        }
        return winners.toList()
    }
}