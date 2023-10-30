package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResult() = println(RESULT_MESSAGE)
    fun printEnter() = println()
    fun printRacingCarList(racingCar: RacingCar) {
        println("${racingCar.racingCarName} : ${printDistance(racingCar.distance)}")
    }

    private fun printDistance(distance: Int): String {
        var temp = ""
        for (i in 0 until distance) {
            temp += DISTANCE_EXPRESS
        }
        return temp
    }

    companion object {
        const val RESULT_MESSAGE = "\n실행 결과"
        const val DISTANCE_EXPRESS = "-"
    }
}