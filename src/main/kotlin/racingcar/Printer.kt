package racingcar


class Printer {

    fun printOutEnteringCarName() = println(Message.ENTERING_CAR_NAME)

    fun printOutEnteringAttemptsNumber() = println(Message.ENTERING_ATTEMPTS_NUMBER)

    fun printOutResultInformationText() = println(Message.RESULT_INFORMATION_TEXT)

    fun printOutRacingWinner(winners: String) = println("최종 우승자 : ${winners}")

    fun printOutCarsMoveResult(carsList: List<Car>) {
        carsList.forEach { car ->
            println("${car.getCarName()} : ${getForwardLineOfCar(car)}")
        }
        println()
    }

    private fun getForwardLineOfCar(car: Car): String {
        var line = ""
        for (i in 1..car.getHowGoForward()) {
            line += "-"
        }
        return line
    }

}