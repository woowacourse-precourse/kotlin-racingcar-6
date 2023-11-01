package racingcar

class Printer {

    fun printOutEnteringCarName() = println(Message.ENTERING_CAR_NAME)

    fun printOutEnteringAttemptsNumber() = println(Message.ENTERING_ATTEMPTS_NUMBER)

    fun printOutResultInformationText() = println(Message.RESULT_INFORMATION_TEXT)

    fun printOutRacingWinner(winners: List<Car>) {
        if (winners.size > 1) {
            val winnersName = winners.joinToString(", ") { it.name }
            println(Message.WINNERS + winnersName)
        } else {
            val winnersName = winners[0].name
            println(Message.WINNERS + winnersName)
        }
    }

    fun printOutCarsMoveResult(carsList: List<Car>) {
        carsList.forEach { car ->
            println("${car.name} : ${getForwardLineOfCar(car)}")
        }
        println()
    }

    private fun getForwardLineOfCar(car: Car): String {
        var line = ""
        for (i in 1..car.howGoForwardCount) {
            line += "-"
        }
        return line
    }

}