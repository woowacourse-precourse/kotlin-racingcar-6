package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start() {
        OutputView().carInputMassage()
        val carNames = InputView().carNameInput()
        val carNamesSeparated = CarNameSeparator().separator(carNames) // 자동차 이름 입력

        OutputView().tryInputMassage()
        val tryNum = InputView().tryNameInput() // 시도 횟수 입력
        Validation().carName(carNamesSeparated)
        val Num = Validation().tryNum(tryNum) // 유효성 검사

        OutputView().racingResult()
        var carProgress: List<String> = CarProgressInit().progress(carNamesSeparated.size)
        for (i in 0..Num - 1) {
            carProgress = RacingGame().racing(carProgress)
            OutputView().eachRacingResult(carNamesSeparated, carProgress)
        } // 자동차 게임 및 출력

        val winners = WinnerDiscrimination().answer(carProgress, carNamesSeparated)
        OutputView().winner(winners) // 우승자 판별 출력
    }
}