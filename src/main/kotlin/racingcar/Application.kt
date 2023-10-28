package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStartMessage()

    getCarName()
}

fun gameStartMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun getCarName() {
    val inputCarName = Console.readLine()
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
        multiCarGame(multiCarName)
    }
    return true
}

fun validateInputMultiCarName(multiCarName: List<String?>) {
    when (false) {
        validateMaxInput5(multiCarName) -> throw IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.")

        validateIsBlank(multiCarName) -> throw IllegalArgumentException("자동차 이름은 필수로 입력해야 합니다.")

        validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException("자동차 이름은 중복하지 않아야 합니다.")

        validateRacingCarRange(multiCarName) -> throw IllegalArgumentException("게임에 참여 가능한 자동차 대수는 1대 이상 7대 이하만 가능합니다.")

        else -> inputTryCount()
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
    var soloCount = 0
    repeat(2) {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        if (randomNum >= 4) {
            soloCount += 1
        }
    }

    if (soloCount >= 1) {
        soloChampion(inputCarName)
    }
}

fun inputTryCount() {
    val tryCount = Console.readLine()
    validateTryCount(tryCount)
}

fun validateTryCount(tryCount: String) {
    when (true) {
        validateNullOrBlank(tryCount) ->
            throw IllegalArgumentException("시도할 횟수를 반드시 입력해야 합니다.")

        validateNotNum(tryCount) ->
            throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

        validateNotInRange(tryCount) ->
            throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

        else -> {}
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

fun multiCarGame(multiCarName: List<String>) {
}

fun soloChampion(carName: String) {
    println("최종 우승자 : $carName")
}
