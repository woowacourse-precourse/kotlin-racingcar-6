package racingcar.View

import racingcar.Model.Car

class OutputView {
    fun printCarsPosition(cars: List<Car>) { // 출력할 때 차의 이름과 위치가 어떻게 나오는지 선으로 보여줌.
        println("\n실행 결과 :")
        cars.forEach {car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    fun printWinners(winner: List<Car>) { // 최종 우승자가 누구인지 알려줌.
        println("최종 우승자 : ${winner.joinToString(",")}")
    }
}