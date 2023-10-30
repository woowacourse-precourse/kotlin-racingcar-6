package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carInput = Console.readLine()
    val splitCarList = splitCarName(carInput)

    println("시도할 횟수는 몇 회인가요?")
    val numberOfMove = Console.readLine()
    checkNumberOfMove(numberOfMove)


}

fun splitCarName(carInput: String): List<String> {
    return when {
        carInput.isBlank() -> throw IllegalArgumentException("빈칸을 입력할 수 없습니다.")
        carInput.split(",").any { it.length > 5 } -> throw IllegalArgumentException("자동차 이름은 5자 이하이며, 쉼표로 구분되어야 합니다.")
        else -> carInput.split(",")
    }
}

fun checkNumberOfMove(numberOfMove : String) {
    return when {
        numberOfMove.isBlank() -> throw IllegalArgumentException("빈칸을 입력할 수 없습니다.")
        numberOfMove.toIntOrNull() == null -> throw IllegalArgumentException("숫자를 입력해야 합니다.")
        numberOfMove.toInt() <= 0 -> throw IllegalArgumentException("양의 정수를 입력하세요.")
        else -> return
    }
}
