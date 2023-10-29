package racingcar.model

class WinnerGenerator {
    private var winners = Winners(mutableListOf<RacingCar>())
    fun win(racingCars: MutableList<RacingCar>): Winners {
        var max = 0
        for (racingCar in racingCars) {
            max = getMax(max, racingCar)
        }
        return winners
    }

    private fun getMax(max: Int, racingCar: RacingCar): Int {
        return if (racingCar.distance.length > max) {
            winners.winnerList.clear()
            winners.winnerList.add(racingCar)
            racingCar.distance.length
        } else if (racingCar.distance.length == max) {
            winners.winnerList.add(racingCar)
            max
        } else {
            max
        }
    }
}