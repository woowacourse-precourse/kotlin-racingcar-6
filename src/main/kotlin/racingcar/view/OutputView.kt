package racingcar.view

import racingcar.model.Car

class OutputView {
    companion object {
        fun printExecutionResultText() {
            println()
            println("실행 결과")
        }

        fun printExecutionResult(cars: List<Car>) {
            for (car in cars) {
                print("${car.carName} : ")
                for (moveCountIndex in 0 until car.moveCount) {
                    print("-")
                }
            }
        }

        fun printGameResult(carName: List<String>) {
            val winningMember:String = carName.joinToString(", ")
            print("최종 우승자 : ${winningMember}")
        }
    }
}