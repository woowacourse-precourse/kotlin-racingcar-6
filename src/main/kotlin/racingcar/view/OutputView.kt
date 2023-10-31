package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResult() = println(RESULT_MESSAGE)
    fun printEnter() = println()
    fun printRackingCars(racingCar: RacingCar) {
        println("${racingCar.racingCarName} : ${printDistance(racingCar.distance)}")
    }

    private fun printDistance(distance: Int): String {
        var temp = ""
        for (i in 0 until distance) {
            temp += DISTANCE_EXPRESS
        }
        return temp
    }

    fun printMaxDistanceRacingCarName(maxDistanceRackingCars: List<String>) =
        println("$FINAL_WINNER_MESSAGE${maxDistanceRackingCars.joinToString(", ")}")


    companion object {
        const val RESULT_MESSAGE = "\n실행 결과"
        const val DISTANCE_EXPRESS = "-"
        const val FINAL_WINNER_MESSAGE = "최종 우승자 : "
        const val COMMA = ","
    }
}