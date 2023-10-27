package racingcar.manager

import racingcar.model.Car

class MessageManager {

    fun printGameStart() = println(GAME_START)

    fun printGameCount() = println(GAME_COUNT)

    fun printGameResult() = println(GAME_RESULT)

    fun printCarProgress(car: Car) =
        println("${car.name} : ${"-".repeat(car.progress)}")

    fun printWinningCars(carList: List<String>) =
        print(GAME_WINNER + carList.joinToString(SEPARATOR))

    companion object {
        const val GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val GAME_COUNT = "시도할 횟수는 몇 회인가요?"
        const val GAME_RESULT = "실행 결과"
        const val GAME_WINNER = "최종 우승자 : "
        const val SEPARATOR = ", "
    }

}