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
                printCarMemberMovement(car.moveCount)
            }
            println()
        }

        fun printGameResult(carName: List<String>) {
            val winningMember: String = carName.joinToString(", ")
            print("최종 우승자 : ${winningMember}")
        }

        private fun printCarMemberMovement(carMoveCount: Int){
            for (moveCountIndex in 0 until carMoveCount) {
                print("-")
            }
            println()
        }
    }
}