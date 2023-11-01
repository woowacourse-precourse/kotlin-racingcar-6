package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun noticeWinner(winnerList: List<RacingCar>) {
        println(WINNER_MESSAGE + winnerList.joinToString(", ") { it.getCarName() })
    }

    fun printCurrentPlace(carList: MutableList<RacingCar>) {
        for (car in carList) {
            val currentPlace = "-".repeat(car.getForward())
            println(car.getCarName() + " : " + currentPlace)
        }
        println("\n")
    }

    fun startGameMessage() = println(START_GAME_MESSAGE)

    companion object {
        const val WINNER_MESSAGE = "최종 우승자 : "
        const val START_GAME_MESSAGE = "실행 결과"
    }
}