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
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input.split(",").map {
            require(it.length <= 5) {"Wrong Car name! Car name must be 5 characters or less"}
            it
        }
    }
    fun getRoundNum(): Int{
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }
}

object OutputManager {

    fun printGameStatus(cars:List<Car>) = cars.forEach{
        val distanceBar = "-".repeat(it.position)
        println("${it.name} : $distanceBar")
    }

    fun printWinners(winners:List<String>) {
        val winnersString = winners.joinToString { ", " }
        println("최종 우승자 : $winnersString")
    }
}

fun main() {
}
