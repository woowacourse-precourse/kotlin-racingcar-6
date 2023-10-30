package racingcar.view

import racingcar.Car

object OutputView {

    private const val OUTPUT_RESULT_TITLE = "실행 결과"

    fun outputResultTitle() = println(System.lineSeparator() + OUTPUT_RESULT_TITLE)

    fun outputCurrentCarPositions(cars: List<Car>) {
        cars.forEach {
            val forward = "-".repeat(it.position)
            println("${it.name} : $forward")
        }
        println()
    }
}