package racingcar.view

import racingcar.domain.Car


class OutputView {

    fun printInputNameOfCars() = println(Message.NAME_OF_CARS)

    fun printInputNumberOfAttempts() = println(Message.NUMBER_OF_ATTEMPTS)

    fun printStartOfResultPhrase() = println(Message.RESULT_PHRASE)

    fun printRoundResultFormat(name: String, position: Int){
        println("$name : ${"-".repeat(position)}")
    }

    fun printWinnerFormat(winnerList: List<Car>){
        val winners = winnerList.joinToString(",")
        println("${Message.FINAL_WINNER_FORMAT} + ${winners}")
    }
}