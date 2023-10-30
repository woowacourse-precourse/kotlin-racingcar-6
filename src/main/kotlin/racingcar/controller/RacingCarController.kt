package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun racingRun() {
        val carNames = inputCarName()
        val tryCount = inputTryRaceCount()
        val cars: List<Cars> = carNames.map { Cars(it) }

        tryRacing(cars, tryCount)
        outputView.raceWinners(cars)
    }

    private fun inputCarName(): List<String> {
        inputView.inputCarNamesMessage()
        val inputName = Console.readLine()
        validateCommaNotFind(inputName)
        return splitInputName(inputName.trim())
    }

    private fun splitInputName(inputName: String): List<String> {
        val splitString = inputName.split(",")
        validateInputName(splitString)
        validateDuplicateCheck(splitString)
        return splitString
    }

    private fun validateInputName(splitInputName: List<String>) {
        splitInputName.map { names ->
            if (names.length > 5) throw IllegalArgumentException("5글자가 넘는 자동차 이름이 있습니다.")
        }
    }

    private fun validateDuplicateCheck(splitInputName: List<String>) {
        for (x in splitInputName) {
            require(splitInputName.count { it == x } <= 1) { "중복된 자동차 이름이 있습니다." } // 같은 수가 1개 이상인 경우
        }
    }

    private fun validateCommaNotFind(inputName: String) {
        if (!inputName.contains(",")){
            throw IllegalArgumentException("입력값에 쉼표가 포함되지 않았습니다.")
        }
    }

    private fun inputTryRaceCount(): Int {
        val tryCount:Int
        inputView.inputTryRaceCountMessage()
        try {
            tryCount = Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 다른 값이 입력 되었습니다.")
        }
        validateInputTryRace(tryCount)

        return tryCount
    }

    private fun validateInputTryRace(tryCount: Int) {
        if (tryCount == 0)
            throw IllegalArgumentException("0은 입력될 수 없습니다.")
    }

    private fun tryRacing(cars: List<Cars>, tryCount: Int) {
        outputView.printHeadResult()
        for (idx in 1..tryCount) {
            cars.map { it.chooseActionFromRandomNumber() }
            outputView.printScore(cars)
        }
    }
}
