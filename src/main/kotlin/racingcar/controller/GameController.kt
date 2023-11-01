package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Car

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    private lateinit var nameList: List<String>
    var car: MutableList<Car> = mutableListOf()
    private var count: Int? = null

    fun runGame() {
        setGame()
        Racing(outputView, count!!, car)
        gameResult()
    }

    private fun setCount(): Int = inputView.inputCount()

    fun setCar() {
        for(i in nameList) { car.add(Car(name = i)) }
    }

    fun setGame() {
        outputView.startCommand()
        nameList = inputView.inputName()
        outputView.getCountCommand()
        count = setCount()
        setCar()
    }

    fun setWinner(): String {
        val highestScore = car.maxOfOrNull { it.score }
        val highestScoreCars = car.filter { it.score == highestScore }
        return highestScoreCars.joinToString(separator = ",") { it.name }
    }

    fun gameResult() {
        val winners = setWinner()
        outputView.winnerOutput(winners)
    }
}