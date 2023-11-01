package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

private const val DISTANCE = "-"

class OutputView {

    fun printInputName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printInputRound() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printWinners(cars: List<Car>) {
        print("최종 우승자 : ")
        print(cars.joinToString(", ") { it.name.value })
    }

    fun printResultMessage() {
        println("\n실행 결과 :")
    }

    fun printRacing(cars: Cars) {
        val racingOutput = buildString {
            cars.getCars().forEach { car ->
                append("${car.name.value} : ")
                append(DISTANCE.repeat(car.position))
                appendLine()
            }
        }
        println(racingOutput)
    }
}