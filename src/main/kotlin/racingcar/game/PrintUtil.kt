package racingcar.game

object PrintUtil {
    private const val START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ASK_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val EXECUTION_RESULT_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "최종 우승자 : "
    private const val SOLE_WINNER_COUNT = 1

    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printAskAttempts() {
        println(ASK_ATTEMPTS_MESSAGE)
    }

    fun printExecutionResult() {
        println(EXECUTION_RESULT_MESSAGE)
    }

    fun printRacingCars(racingCars: List<Car>) {
        racingCars.forEach { _car ->
            println(_car)
        }
        println()
    }

    fun printWinnerList(winnerList: MutableList<Car>) {
        print(WINNER_MESSAGE)
        if (winnerList.size > SOLE_WINNER_COUNT) {
            winnerList.forEach{ _car ->
                if (winnerList.last() != _car){
                    print(_car.getName() + ", ")
                }
                else {
                    print(_car.getName())
                }
            }
            return
        }
        print(winnerList.first().getName())
    }
}