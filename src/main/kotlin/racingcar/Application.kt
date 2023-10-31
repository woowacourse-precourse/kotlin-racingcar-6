package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Refree(
    private val namesOfParticipants: List<String>,
    private val roundNum: Int,
    val doSomethingWithCarsAfterRound: (List<Car>) -> Unit
) {
    val cars: List<Car> = namesOfParticipants.map{Car(it)}

    fun runRound() {
        cars.forEach{it.goForwardOrStop()}
        doSomethingWithCarsAfterRound(cars)
    }
    fun runAllRounds() = repeat(roundNum){ runRound() }
    fun getGameStatus() = cars
    fun getWinners(): List<Car> {
        runAllRounds()
        val winnerPosition = cars.max().position
        return cars.filter{it.position == winnerPosition}
    }
}

class Car(val name: String) : Comparable<Car> {
    var position = 0
        private set

    init {
        require(name.length <= 5){ "Car name length exceeds 5 letters" }
    }

    fun goForwardOrStop() {
        val random = Randoms.pickNumberInRange(0,9)
        if (random >= 4) {
            position++
        }
    }

    override fun compareTo(other: Car): Int = compareValuesBy(this, other, Car::position)

}

object InputManager {
    fun getCarNames() : List<String> {
        val input = Console.readLine()
        return input.split(",").map {
            require(it.length <= 5) {"Wrong Car name! Car name must be 5 characters or less"}
            it
        }
    }
}

object OutputManager {

    fun printGameStatus(cars:List<Car>) = cars.forEach{
        val distanceBar = "-".repeat(it.position)
        println("${it.name} : $distanceBar")
    }

    //- [ ] 누가 우승했는지 출력해야 한다. OutputManager#printWinner()
    fun printWinners(winners:List<String>) {
        val winnersString = winners.joinToString { ", " }
        println("최종 우승자 : $winnersString")
    }
}

fun main() {
    // TODO: 프로그램 구현
}
