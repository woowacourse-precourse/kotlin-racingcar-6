package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Car

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    private lateinit var nameList: List<String>
    private var car: MutableList<Car> = mutableListOf()
    private var count: Int? = null

    fun runGame() {
        setGame()
        Racing(outputView, count!!, car)
        gameResult()
    }

    private fun setCount(): Int = inputView.inputCount()

    private fun setCar() {
        for(i in nameList) { car.add(Car(name = i)) }
    }

    private fun setGame() {
        outputView.startCommand()
        nameList = inputView.inputName()
        outputView.getCountCommand()
        count = setCount()
        setCar()
    }

    private fun setWinner(): String {
        val highestScore = car.maxOfOrNull { it.score }
        val highestScoreCars = car.filter { it.score == highestScore }
        return highestScoreCars.joinToString(separator = ",") { it.name }
    }

    private fun gameResult() {
        val winners = setWinner()
        outputView.winnerOutput(winners)
    }
}