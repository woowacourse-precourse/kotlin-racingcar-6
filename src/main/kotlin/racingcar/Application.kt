package racingcar

fun main() {
    val participants = InputManager.getCarNames()
    val roundNum = InputManager.getRoundNum()
    val referee = Referee(
        namesOfParticipants = participants,
        roundNum = roundNum,
        OutputManager::printGameStatus
    )
    println("실행 결과")
    val winners = referee.getWinners()
    OutputManager.printWinners(winners)
}
