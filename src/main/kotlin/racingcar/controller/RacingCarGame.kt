package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Referee
import racingcar.presentation.InputView
import racingcar.presentation.OutputView

typealias Cars = List<Car>
typealias RoundNumbers = Int

class RacingCarGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun play() {
        val cars = createCars()
        val roundNumbers = getRoundNumbers()
        val referee = Referee(cars)

        outputView.printResultTitle()
        repeat(roundNumbers) {
            playSingleRound(referee)
        }

        announceWinner(referee)
    }

    private fun createCars(): Cars =
        try {
            val carLineUp = inputView.readCarLineUp()
            val carNames = carLineUp.split(",")
            val cars = carNames.map { Car(it) }
            require(cars.doesNotHaveDuplicates()) { "[ERROR] 중복된 차 이름이 있습니다." }
            cars
        } catch (e: IllegalArgumentException) {
            println(e.message)
            createCars()
        }

    private fun Cars.doesNotHaveDuplicates(): Boolean = this.size == this.toSet().size

    private fun getRoundNumbers(): RoundNumbers =
        try {
            val roundNumbers = inputView.readRoundNumbers()
            require(roundNumbers.isValid()) { "[ERROR] 시도할 횟수 값이 잘못 됐습니다. 유효하지 않은 값입니다." }
            roundNumbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getRoundNumbers()
        }

    private fun RoundNumbers.isValid(): Boolean = this >= 1

    private fun playSingleRound(referee: Referee) =
        outputView.printEachRoundResult(referee.judgeEachRound())

    private fun announceWinner(referee: Referee) =
        outputView.printWinner(referee.judgeWinner().keys.map { it.name })
}