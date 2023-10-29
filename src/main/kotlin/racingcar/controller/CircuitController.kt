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
        while (circuit.state != CircuitState.End) {
            when (circuit.state) {
                CircuitState.Start -> {
                    outputView.printGameStartMessage()
                    circuit.makeCars(inputView.inputCars())
                }

                CircuitState.Racing -> {
                    outputView.printGameInputAttemptMessage()
                    val attempt = inputView.inputAttempt()
                    outputView.printGameResultMessage()
                    circuit.moveCars(attempt)
                }

                CircuitState.End -> {
                    //TODO 승자선정하기
                    //TODO 승자 출력하기
                }
            }
        }
    }
}