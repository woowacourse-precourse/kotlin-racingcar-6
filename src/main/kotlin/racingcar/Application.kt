package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    printGameStartMessage()
}

fun printGameStartMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun inputCarNames(): String {
    return Console.readLine()
}

fun separateCarNames(carNames: String): List<String> {
    return carNames.split(",")
}

fun validateNameLength(carList: List<String>) {
    carList.forEach {
        if (it.length > 5) throw IllegalArgumentException("차 이름의 길이가 5보다 큽니다.")
    }
}
