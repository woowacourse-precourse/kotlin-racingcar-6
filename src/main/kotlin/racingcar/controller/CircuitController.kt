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
                    //TODO 게임 시작 메시지 출력
                    //TODO 자동차 이름 입력 받기
                    //TODO 입력받은 자동차로 자동차 추가하기
                }

                CircuitState.Racing -> {
                    //TODO 시도 횟수 메시지 출력
                    //TODO 시도 횟수 입력받기
                    //TODO 시도 횟수만큼 자동차 움직이기 시도하기
                }

                CircuitState.End -> {
                    //TODO 승자선정하기
                    //TODO 승자 출력하기

                }
            }
        }
    }
}