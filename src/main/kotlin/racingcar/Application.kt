package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = getCarNames()
    val rounds = getRounds()

    val cars = carNames.map { Car(it)}
    val game = Game(cars, rounds)
    game.start()
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val carNames = userInput.split(",").map { it.trim() }

    if (carNames.size < 2) {
        throw IllegalArgumentException("자동차 경주 게임을 시작하기 위해서는 2대 이상의 자동차가 필요합니다.")
    }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("이름은 5자 이하만 가능합니다.")
    }

    return carNames
}

fun getRounds(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val userInput = Console.readLine()
    if (userInput.any { !it.isDigit() }) {
        throw IllegalArgumentException("입력값은 숫자여야 합니다.")
    }

    val inputNumber = userInput.toInt()
    if (inputNumber < 1) {
        throw IllegalArgumentException("시도할 횟수가 적절하지 않습니다.")
    }
    return userInput.toInt()
}
