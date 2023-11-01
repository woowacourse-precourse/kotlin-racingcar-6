package racingcar

object PrintUtils {
    fun printCars(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.getName()} : ${"-".repeat(car.getPosition())}")
        }
    }

    fun printWinners(winners: String) {
        println("최종 우승자 : $winners")
    }
}