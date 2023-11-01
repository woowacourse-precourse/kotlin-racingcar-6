package racingcar.domain

class Game() {
    fun result(cars: List<Car>?): Map<String, Int> {
        return cars!!.associateBy({ it.name }, { it.position })
    }

    fun start(cars: List<Car>?) {
        cars!!.forEach { car ->
            val randomNum = car.getRandoms()
            car.move(randomNum) }
        cars.forEach { car ->
            println(car.getResult())}

    }

    fun awardWinner(result: Map<String, Int>): List<String> {
        val maxEntry = result.maxByOrNull { it.value }
        val maxValue = maxEntry?.value
        val winner = result.filterValues { it == maxValue }.keys.toList()

        return winner
    }

}