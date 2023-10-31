package racingcar.domain

class Winner(var cars: MutableList<Car>) {
    fun getWinners(): MutableList<Car> {
        var winners: MutableList<Car>
        var topCount = 0

        for (car in cars) {
            if (car.count >= topCount) {
                topCount = car.count
            }
        }

        winners = cars.filter { it.count == topCount }.toMutableList()
        return winners
    }

    fun print() {
        println("최종 우승자 : ${getWinners().joinToString(", ")}")
    }
}