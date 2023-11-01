package racingcar.view

import racingcar.model.Cars

class OutputView {
    fun showStartGuide() = println(START_GUIDE_MESSAGE)

    fun showTryCountGuide() = println(TRY_COUNT_GUIDE_MESSAGE)

    fun showResultGuide() = println(RESULT_GUIDE_MESSAGE)

    fun showRace(cars: Cars) {
        cars.cars.forEach {
            println(it.name + START_LANE + CAR_POSITION_SYMBOL.repeat(it.position))
        }
        println()
    }

    fun showResult(cars: List<String>) = print("$FINAL_WINNER_LABEL ${cars.joinToString(DELIMITER)}")

    companion object {
        const val START_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val TRY_COUNT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val RESULT_GUIDE_MESSAGE = "실행 결과"
        const val START_LANE = " : "
        const val CAR_POSITION_SYMBOL = "-"
        const val FINAL_WINNER_LABEL = "최종 우승자 :"
        const val DELIMITER = ", "
    }

}