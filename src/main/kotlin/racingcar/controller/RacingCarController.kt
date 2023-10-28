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
    }

    private fun inputCarName(): List<String> {
        inputView.inputCarNamesMessage()
        val inputName = Console.readLine()
        val carNames = splitInputName(inputName.trim())
        return carNames
    }

    private fun splitInputName(inputName: String): List<String> {
        val splitInputName = inputName.split(",")
        validateInputName(splitInputName)
        return splitInputName
    }

    private fun validateInputName(splitInputName: List<String>) {
        splitInputName.map { names ->
            if (names.length > 5) throw IllegalArgumentException("5글자가 넘는 자동차 이름이 있습니다.")
        }
    }

    private fun inputTryRaceCount(): Int {
        var tryCount: Int = 0
        inputView.inputTryRaceCountMessage()
        try {
            tryCount = Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 다른 값이 입력되었습니다.")
        }
        validateInputTryRace(tryCount)

        return tryCount
    }

    private fun validateInputTryRace(tryCount: Int) {
        if (tryCount == 0)
            throw IllegalArgumentException("0은 입력될 수 없습니다.")
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun chooseActionFromRandomNumber(): Boolean {
        val randomNumber = generateRandomNumber()
        var move = 0
        when {
            randomNumber >= 4 -> move = 1
            randomNumber < 4 -> move = 0
        }
        return move == 1
    }

    private fun moveCarsBasedOnRandomConditions(cars: List<Cars>) {
        for (car in cars) {
            if (chooseActionFromRandomNumber()) {
                car.carPosition++
            }
        }
    }

    private fun tryRacing(cars: List<Cars>, tryCount: Int) {
        for (idx in 1..tryCount) {
            moveCarsBasedOnRandomConditions(cars)
            outputView.drawDashOnMoveForward(cars)
            println()
        }
    }
}