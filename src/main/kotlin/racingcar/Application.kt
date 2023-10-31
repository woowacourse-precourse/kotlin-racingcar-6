package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.system.exitProcess

fun main() {
    val carNames = getCarNames()
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine()
    checkCarNames(carNames)
    return carNames.split(",")
}

fun checkCarNames(carNames: String) {
    val names = carNames.split(",")
    if (names.any { it.isEmpty() || it.length > 5 }) {
        exitProcess(0)
    }
}
