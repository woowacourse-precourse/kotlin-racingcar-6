package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Refree(
    private val namesOfParticipants: List<String>,
    private val roundNum: Int
) {
    val cars: List<Car> = namesOfParticipants.map{Car(it)}

    fun runRound() = cars.forEach{it.goForwardOrStop()}
    fun getGameStatus(): List<Int> = cars.map{it.position}
    fun getWinners(): List<Car> {
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

fun main() {
    // TODO: 프로그램 구현
}
