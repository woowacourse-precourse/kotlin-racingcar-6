package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResult() = println(RESULT_MESSAGE)
    fun printEnter() = println()
    fun printRacingCar(racingCar: RacingCar) {
        println("${racingCar.racingCarName} : ${printDistance(racingCar.getDistance())}")
    }

    private fun printDistance(distance: Int): String {
        val builder = StringBuilder()
        repeat(distance) {
            builder.append(DISTANCE_EXPRESS)
        }
        return builder.toString()
    }

    fun printMaxDistanceRacingCarName(maxDistanceRacingCars: List<String>) =
        println("$FINAL_WINNER_MESSAGE${maxDistanceRacingCars.joinToString(COMMA)}")


    companion object {
        private const val RESULT_MESSAGE = "\n실행 결과"
        private const val DISTANCE_EXPRESS = "-"
        private const val FINAL_WINNER_MESSAGE = "최종 우승자 : "
        private const val COMMA = ", "
    }
}