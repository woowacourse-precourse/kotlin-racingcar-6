package racingcar.view

import racingcar.game.Car

object OutputView {

    private const val OUTPUT_RESULT_TITLE = "실행 결과"
    private const val OUTPUT_FINAL_WINNER = "최종 우승자 : %s"

    fun outputResultTitle() = println(System.lineSeparator() + OUTPUT_RESULT_TITLE)

    fun outputCurrentCarPositions(cars: List<Car>) {
        cars.forEach {
            val forward = "-".repeat(it.position)
            println("${it.name} : $forward")
        }
        println()
    }

    fun outputFinalWinners(cars: List<Car>) =
        println(OUTPUT_FINAL_WINNER.format(cars.joinToString(", ") { it.name }))
}