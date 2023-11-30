package racingcar.view

import racingcar.model.Cars

class OutputView {

    fun showResultHeader() = println(TRY_RESULT_HEADER)
    fun showTryResult(cars: Cars) {
        repeat(cars.cars.size) {
            val car = cars.cars[it]
            println("${car.name} : " + "-".repeat(car.position))
        }
    }

    companion object {
        const val TRY_RESULT_HEADER = "실행 결과"
    }
}