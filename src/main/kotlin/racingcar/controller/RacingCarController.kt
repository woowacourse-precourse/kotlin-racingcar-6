package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
        private val inputView: InputView,
        private val outputView: OutputView
) {
    fun run() {
        outputView.printRacingCarNameInstructions()
        val racingCarList = makeRacingCarList(inputView.getRacingCarName())

        outputView.printAttemptNumberInstruction()
        for (attemptNumber in 0 until inputView.getAttemptNumber()) {
            moveOrStop(racingCarList)

            outputView.printAttemptResult(attemptNumber, racingCarList)
        }

        outputView.printWinner(racingCarList)
    }

    // 기능 3. 자동차 리스트 만들기
    private fun makeRacingCarList(racingCarNameList: List<String>): List<RacingCar> {
        val racingCarList = mutableListOf<RacingCar>()
        for (name in racingCarNameList) {
            racingCarList.add(RacingCar(name))
        }

        return racingCarList
    }

    // 기능 6. 무작위 값 구하기
    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    // 기능 7. 전진, 정지 판단하기
    private fun moveOrStop(racingCarList: List<RacingCar>) {
        for (racingCar in racingCarList) {
            if (generateRandomNumber() >= 4) {
                racingCar.move()
            }
        }
    }
}