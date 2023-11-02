package racingcar.view

import model.Car

class OutputView {
    fun printInputCarNameMessage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printInputCountMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCarDistance(car: Car) {
        println("${car.name} : ${"-".repeat(car.distance)}")
    }

    fun printWinners(winners: List<String>) {
        val output = winners.joinToString(", ")
        println(output)
    }
}