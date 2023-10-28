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
        raceWinners(cars)
    }

    private fun inputCarName(): List<String> {
        inputView.inputCarNamesMessage()
        val inputName = Console.readLine()
        return splitInputName(inputName.trim())
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

    private fun racePointMax(cars: List<Cars>): Int? {
        return cars.maxOfOrNull { it.carPosition }
    }

    private fun raceWinners(cars: List<Cars>) {
        val maxPosition = racePointMax(cars)
        if (maxPosition != null) {
            val winners = cars.filter { it.carPosition == maxPosition }
            println("최종 우승자 : ${winners.joinToString(", ") { it.carName }}")
        }
    }
}
