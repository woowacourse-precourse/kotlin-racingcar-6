package racingcar.controller

import racingcar.domain.car.CarsRaceEnded
import racingcar.domain.car.CarsRacing
import racingcar.domain.move.MoveDecider
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val moveDecider: MoveDecider,
) {

    fun run() {
        val carsRacing = inputView.inputCreateCarsDto().into()
        play(carsRacing)
        printWinners(carsRacing.intoCarsRaceEnded())
    }

    private fun play(carsRacing: CarsRacing) {
        val maxRound = inputView.inputMaxRound()
        _play(carsRacing, maxRound)
    }

    private fun _play(carsRacing: CarsRacing, countDown: Int) {
        carsRacing.moveAllBy(moveDecider)

        val carsDto = carsRacing.intoCarsDto()
        outputView.printRoundResult(carsDto)

        if (countDown > 0) {
            _play(carsRacing, countDown - 1)
        }
    }

    private fun printWinners(carsRaceEnded: CarsRaceEnded) {
        val winnersDto = carsRaceEnded.intoWinnersDto()
        outputView.printWinners(winnersDto)
    }
}