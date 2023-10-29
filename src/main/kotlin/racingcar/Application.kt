package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = getCarNames()
    val rounds = getRounds()

    val cars = carNames.split(",").map { Car(it)}
    val game = Game(cars, rounds)
    game.start()
}

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun getRounds(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val userInput = Console.readLine()
    if (userInput.any { !it.isDigit() }) {
        throw IllegalArgumentException("입력값은 숫자여야 합니다.")
    }
    return userInput.toInt()
}
