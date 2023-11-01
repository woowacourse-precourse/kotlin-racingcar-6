package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
}

fun getCarNames():List<String> {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val carName = userInput.split(",")

    return carName
}