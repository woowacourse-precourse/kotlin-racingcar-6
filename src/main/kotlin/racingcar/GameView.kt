package racingcar
import racingcar.model.CarModel

class GameView {
    fun displayRaceStatus(cars: List<CarModel>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun displayWinner(winners: List<CarModel>) {
        val winnerNames = winners.map { it.name }.joinToString(", ")
        println("최종 우승자 : $winnerNames")
    }
}