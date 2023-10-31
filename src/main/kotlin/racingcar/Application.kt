package racingcar

import racingcar.domain.CarName
import racingcar.domain.CarRace
import racingcar.domain.Referee
import racingcar.domain.RoundNumber

fun main() {
    val carName = CarName()
    carName.requestInput()
    val getCarName = carName.getInput()
    val carNames = carName.validateInput(getCarName)

    val roundNumber = RoundNumber()
    roundNumber.requestInput()
    val getRoundNumber = roundNumber.getInput()
    val round = roundNumber.validateInput(getRoundNumber)

    val carRace = CarRace()
    val scoreList = MutableList(carNames.size) { CarRaceConstants.INITIALIZATION_ZERO }
    val carScore = carNames.zip(scoreList).toMutableList()
    carRace.startFlag()
    repeat(round) {
        carRace.runRound(carScore)
        carRace.printRound(carScore)
    }

    val referee = Referee()
    val maxScore = referee.findMaxScore(carScore)
    val winnerName = referee.findWinner(carScore, maxScore)
    referee.printWinner(winnerName)
}