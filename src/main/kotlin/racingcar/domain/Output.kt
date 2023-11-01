package racingcar.domain

class Output() {

    fun printState(carList: List<Car>) {
        carList.forEach { car ->
            println("${car.name} : ${"-".repeat(car.advanceState)}")
        }
    }

    fun printResult(winnerList: List<String>) {
        print("최종 우승자 : ${winnerList.joinToString(", ")}")
    }

}