package racingcar.view


class OutputView {

    fun printInputNameOfCars() = println(Message.NAME_OF_CARS)

    fun printInputNumberOfAttempts() = println(Message.NUMBER_OF_ATTEMPTS)

    fun printAllRoundsResult(){

    }

    fun printFinalWinners() {
        println(Message.FINAL_WINNER_FORMAT.format())
    }

    fun formatOfFinalResults(score: Int) = "-".repeat(score)

    fun formatOfFinalWinners(){

    }
}