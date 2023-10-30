import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

fun main() {
    vla cars=inputCarNames()
}

fun inputCarNames(): List<Car> { //차 이름 입력받기
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    return carNames.map { Car(it) }
}