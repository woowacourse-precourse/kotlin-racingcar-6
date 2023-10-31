package racingcar.controller

import racingcar.model.Circuit
import racingcar.model.CircuitState
import racingcar.view.InputView
import racingcar.view.OutputView

class CircuitController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun run() {
        val circuit = Circuit()
        while (circuit.state != CircuitState.EXIT) {
            proceedCircuit(circuit)
        }
    }

    private fun proceedCircuit(circuit: Circuit) {
        when (circuit.state) {
            CircuitState.START -> {
                outputView.printGameStartMessage()
                circuit.makeCars(inputView.inputCars())
            }

            CircuitState.RACING -> {
                outputView.printGameInputAttemptMessage()
                val attempt = inputView.inputAttempt()
                println()
                outputView.printGameResultMessage()
                circuit.moveCars(attempt)
            }

            CircuitState.END -> {
                val winners = circuit.findWinner()
                outputView.printGameWinnerMessage(winners)
            }

            CircuitState.EXIT -> return
        }
    }
}