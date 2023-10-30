package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.views.InputView
import racingcar.views.OutputView

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    inputView.gameStartMessage()

    getCarName()
}

fun getCarName() {
    val inputCarName = inputView.inputView()
    validateInputBlank(inputCarName)
    checkSoloCar(inputCarName)
}

fun validateInputBlank(inputCarName: String) {
    if (inputCarName.isBlank()) {
        throw IllegalArgumentException("자동차 이름을 반드시 입력해야 합니다.")
    }
}

private fun checkSoloCar(inputCarName: String): Boolean {
    if (!inputCarName.contains(",")) {
        soloCarGame(inputCarName)
    } else {
        val multiCarName = inputCarName.split(",")
        validateInputMultiCarName(multiCarName)
    }
    return true
}

fun validateInputMultiCarName(multiCarName: List<String?>) {
    when (false) {
        validateMaxInput5(multiCarName) -> throw IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.")

        validateIsBlank(multiCarName) -> throw IllegalArgumentException("자동차 이름은 필수로 입력해야 합니다.")

        validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException("자동차 이름은 중복하지 않아야 합니다.")

        validateRacingCarRange(multiCarName) -> throw IllegalArgumentException("게임에 참여 가능한 자동차 대수는 1대 이상 7대 이하만 가능합니다.")

        else -> inputTryCount(multiCarName)
    }
}

fun validateMaxInput5(multiCarName: List<String?>): Boolean {
    for (element in multiCarName) {
        if (element == null || element.length > 5) {
            return false
        }
    }
    return true
}

fun validateIsBlank(multiCarName: List<String?>): Boolean {
    for (element in multiCarName) {
        if (element!!.isBlank()) {
            return false
        }
    }
    return true
}

fun validateDuplicateCarName(multiCarName: List<String?>): Boolean {
    return multiCarName.size == multiCarName.distinct().count()
}

fun validateRacingCarRange(multiCarName: List<String?>): Boolean {
    return multiCarName.size <= 7
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
    validateTryCount(tryCount, multiCarName)
}

fun validateTryCount(tryCount: String, multiCarName: List<String?>) {
    when (true) {
        validateNullOrBlank(tryCount) -> throw IllegalArgumentException("시도할 횟수를 반드시 입력해야 합니다.")

        validateNotNum(tryCount) -> throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

        validateNotInRange(tryCount) -> throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

        else -> multiRacingGame(tryCount.toInt(), multiCarName)
    }
}

fun validateNotNum(tryCount: String?): Boolean {
    return tryCount!!.toIntOrNull() == null
}

fun validateNotInRange(tryCount: String?): Boolean {
    return tryCount!!.toInt() !in 1..10
}

fun validateNullOrBlank(tryCount: String?): Boolean {
    return tryCount.isNullOrBlank()
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
    val randomNum = getRandomNum()
    if (checkPositiveForward(randomNum)) {
        scoreMap[carName!!] = scoreMap.getOrDefault(carName, 0) + 1
    }
}

fun getRandomNum(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

fun checkPositiveForward(randomNum: Int): Boolean {
    return randomNum >= 4
}

fun multiChampion() {
    val highestScore = scoreMap.values.maxOrNull() ?: 0
    val winners = scoreMap.filter { it.value == highestScore && it.key != null }.keys
    outputView.printMultiWinner(winners)
}
