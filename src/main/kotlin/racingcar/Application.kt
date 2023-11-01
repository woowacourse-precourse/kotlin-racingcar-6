package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class Car(val name: String, var distance: Int = 0) {
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }
    override fun toString(): String {
        return "$name : ${"-".repeat(distance)}"
    }
}
fun race(cars: List<Car>, rounds: Int) {
    repeat(rounds) {
        cars.forEach { it.move() }
        cars.forEach { println(it) }
        println()
    }

    val maxDistance = cars.maxOf { it.distance }
    val winners = cars.filter { it.distance == maxDistance }

    println("최종 우승자 : ${winners.joinToString { it.name }}")
}
fun main() {
    println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(",")

    if (carNames.any { it.length > 5 || it.any { it.isDigit() } }) {
        throw IllegalArgumentException()
    }

    println("시도할 횟수는 몇 회인가요?")
    val rounds = Console.readLine().toInt()

    val cars = carNames.map { Car(it) }
    race(cars, rounds)
}

