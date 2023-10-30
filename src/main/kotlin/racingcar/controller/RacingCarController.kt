package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.printRacingCarNameInstruction()
        val racingCarList = makeRacingCarList(inputView.inputRacingCarName())

        outputView.printAttemptNumberInstruction()
        for (attemptNumber in 0 until inputView.inputAttemptNumber()) {
            moveOrStop(racingCarList)

            if (attemptNumber == 0) {
                outputView.printResultHeader()
            }

            outputView.printAttemptResult(racingCarList)
        }

        outputView.printWinner(findWinner(racingCarList))
    }

    // 기능 3. 자동차 리스트 만들기
    fun makeRacingCarList(racingCarNameList: List<String>): List<RacingCar> {
        return racingCarNameList.map { racingCarName -> RacingCar(racingCarName) }
    }

    // 기능 6. 무작위 값 구하기
    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    // 기능 7. 전진, 정지 판단하기
    fun moveOrStop(racingCarList: List<RacingCar>) {
        for (racingCar in racingCarList) {
            if (generateRandomNumber() >= 4) {
                racingCar.move()
            }
        }
    }

    // 기능 9. 우승자 안내하기
    fun findWinner(racingCarList: List<RacingCar>): List<RacingCar> {
        val maxMove = racingCarList.maxBy { racingCar -> racingCar.totalMove }.totalMove

        return racingCarList.filter { racingCar -> racingCar.totalMove == maxMove }
    }
}