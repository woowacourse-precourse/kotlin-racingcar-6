package racingcar

fun main() {
    val participants = InputManager.getCarNames()
    val roundNum = InputManager.getRoundNum()
    val referee = Referee(
        namesOfParticipants = participants,
        roundNum = roundNum,
        doSomethingWithCarsAfterRound = OutputManager::printGameStatus,
    )
    println(Resources.RESULT_OF_GAME)
    val winners = referee.getWinners()
    OutputManager.printWinners(winners)
}
