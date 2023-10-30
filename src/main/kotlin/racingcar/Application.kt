import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

fun main() {
    vla cars=inputCarNames()
}

fun inputCarNames(): List<Car> { //자동차 이름 입력받기
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException()
    }
    return carNames.map { Car(it) }
}

fun inputNumberOfMoves(): Int { //이동 횟수 입력
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()
    val numberOfMoves = input.toIntOrNull()

    if (numberOfMoves == null || numberOfMoves <= 0) {
        throw IllegalArgumentException("유효한 이동 횟수를 입력하세요.")
    }

    return numberOfMoves
}
fun move(car: Car) { //자동차 0~9랜덤 추출 후 4이상이면 포지션 증가
    val randomValue = Randoms.pickNumberInRange(0, 9)

    if (randomValue >= 4) {
        car.position++
    }
}