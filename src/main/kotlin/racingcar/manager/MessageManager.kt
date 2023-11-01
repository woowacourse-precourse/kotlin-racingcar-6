package racingcar.manager

import racingcar.model.Car

// 게임의 출력을 담당하는 매니저입니다.
class MessageManager {

    fun printGameStart() = println(GAME_START)

    fun printGameCount() = println(GAME_COUNT)

    fun printGameResult() = println(GAME_RESULT)

    fun printOneRacingResult(carList: List<Car>) {
        for (car in carList)
            printCarProgress(car)
        println()
    }

    private fun printCarProgress(car: Car) =
        println("${car.name} : ${"-".repeat(car.progress)}")

    // 구분자(SEPARATOR) 삽입해서 carList 출력
    fun printWinningCars(carList: List<String>) =
        print(GAME_WINNER + carList.joinToString(SEPARATOR))

    companion object {
        private const val GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val GAME_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val GAME_RESULT = "\n실행 결과"
        private const val GAME_WINNER = "최종 우승자 : "
        private const val SEPARATOR = ", "
    }

}