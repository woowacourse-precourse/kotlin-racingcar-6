package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.ValidateCarName
import racingcar.model.ValidateRacingCount
import racingcar.utils.RandomUtils
import racingcar.views.InputView
import racingcar.views.OutputView

private val inputView = InputView()
private val outputView = OutputView()
private val validateCarName = ValidateCarName()
private val validateRacingCount = ValidateRacingCount()
private val randomUtils = RandomUtils()
fun main() {
    inputView.gameStartMessage()

    getCarName()
}

fun getCarName() {
    val inputCarName = inputView.inputView()
    validateCarName.validateInputBlank(inputCarName)
    checkSoloCar(inputCarName)
}

private fun checkSoloCar(inputCarName: String): Boolean {
    if (!inputCarName.contains(",")) {
        soloCarGame(inputCarName)
    } else {
        val multiCarName = inputCarName.split(",")
        validateCarName.validateInputMultiCarName(multiCarName)
    }
    return true
}

fun soloCarGame(inputCarName: String) {
    outputView.printSoloGameRules()
    var soloCount = 0
    repeat(2) {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        if (checkPositiveForward(randomNum)) {
            soloCount++
        }
        val forward = "-".repeat(soloCount)
        outputView.printSoloGameResult(inputCarName, forward)
    }

    if (soloCount >= 1) {
        outputView.printSoloWinner(inputCarName)
    } else {
        outputView.printNoWinner()
    }
}

fun inputTryCount(multiCarName: List<String?>) {
    inputView.inputTryCountMessage()
    val tryCount = inputView.inputView()
    racingcar.validateRacingCount.validateTryCount(tryCount, multiCarName)
}

fun multiRacingGame(tryCount: Int, multiCarName: List<String?>) {
    outputView.printResultMessage()
    repeatRacing(tryCount, multiCarName)
}

val scoreMap = mutableMapOf<String, Int>()

fun repeatRacing(tryCount: Int, multiCarName: List<String?>) {
    repeat(tryCount) {
        racingEachCar(multiCarName)
        outputView.printMultiGameResult(multiCarName)
    }
    multiChampion()
}

fun racingEachCar(multiCarName: List<String?>) {
    for (carName in multiCarName) {
        racingSingleCar(carName)
    }
}

fun racingSingleCar(carName: String?) {
    val randomNum = randomUtils.getRandom()
    if (checkPositiveForward(randomNum)) {
        scoreMap[carName!!] = scoreMap.getOrDefault(carName, 0) + 1
    }
}

fun checkPositiveForward(randomNum: Int): Boolean {
    return randomNum >= 4
}

fun multiChampion() {
    val highestScore = scoreMap.values.maxOrNull() ?: 0
    val winners = scoreMap.filter { it.value == highestScore && it.key != null }.keys
    outputView.printMultiWinner(winners)
}
