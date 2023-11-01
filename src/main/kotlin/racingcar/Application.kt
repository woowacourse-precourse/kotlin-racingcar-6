package racingcar
import racingcar.inputNames

fun main() {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ")
    val userInput = readLine() ?: ""
    try {
        val inputNames = inputNames(userInput)
        val names = inputNames.getNames()
        println("입력한 이름 목록:")
        names.forEach { println(it) }
    } catch (e: IllegalArgumentException) {
        println("오류: ${e.message}")}
}

