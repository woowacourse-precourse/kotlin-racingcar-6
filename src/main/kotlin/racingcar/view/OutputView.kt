package racingcar.view

import racingcar.model.Car
import racingcar.util.GameMessage

class OutputView {
    fun printGameStartMessage() = println(GameMessage.GAME_START_MESSAGE)
    fun printGameInputAttemptMessage() = println(GameMessage.GAME_INPUT_ATTEMPT_MESSAGE)
    fun printGameResultMessage() = println(GameMessage.GAME_RESULT_MESSAGE)
    fun printGameWinnerMessage() = println(GameMessage.GAME_WINNER_MESSAGE)//TODO 우승자 리스트 받아서 ,로 구분 출력
    fun printGameStatusMessage(cars : List<Car>){
        for(car in cars){
            println(car)
        }
        println()
    }
}