package racingcar

class RacingCarGameResultEvaluator {
    fun racingCarGameJudge(cars: MutableList<RacingCar>) : MutableList<String> {
        val winners = mutableListOf<String>()
        var max = Int.MIN_VALUE
        for(car in cars) {
            max = Math.max(max, car.distance)
        }
        for(car in cars) {
            if(car.distance == max) {
                winners.add(car.name)
            }
        }
        return winners
    }
}