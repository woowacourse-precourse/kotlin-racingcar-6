package racingcar.domain

class Output() {

    fun printState(carList: List<Car>) {
        carList.forEach { car ->
            println("${car.name} : ${ADVANCE_STATE.repeat(car.advanceState)}")
        }
    }

    fun printResult(winnerList: List<String>) {
        print("${WINNER_MESSAGE}${winnerList.joinToString(", ")}")
    }

    companion object {
        const val WINNER_MESSAGE = "최종 우승자 : "
        const val ADVANCE_STATE = "-"
    }

}