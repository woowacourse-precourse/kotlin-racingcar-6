package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val MIN_VALUE: Int = 0
val MAX_VALUE: Int = 9

val START_MESSAGE: String = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
val TRIAL_MESSAGE: String = "시도할 횟수는 몇 회인가요?"
val RESULT_MESSAGE: String = "실행 결과"
val WINNER_MESSAGE: String = "최종 우승자 :"

val NOT_NUMBER_ERROR_MESSAGE: String = "숫자를 입력해주세요"
val LACK_OF_CARS_ERROR_MESSAGE: String = "경주할 자동차 이름을 두 대 이상 입력하세요"
val TOO_LONG_CAR_NAME_ERROR_MESSAGE: String = "자동차 이름은 5자 이하만 가능합니다"

fun main() {
    startGame()
}

fun startGame() {

    println(START_MESSAGE)
    var CarNames: List<String> = getCarNames()
    println(TRIAL_MESSAGE)
    val trialCount: Int? = Console.readLine().toIntOrNull()
    require(isNumberTrialCountValidation(trialCount)){
        NOT_NUMBER_ERROR_MESSAGE
    }

    println(RESULT_MESSAGE)
    var moveResult: MutableList<String> = MutableList(CarNames.size) { "" }
    repeat(trialCount!!){
        moveResult = runOneRound(CarNames, moveResult)
        printOneRound(CarNames, moveResult)
        println("")
    }

    val winnerNames: String = getWinnerNames(CarNames, moveResult)
    println("$WINNER_MESSAGE $winnerNames")
}

fun getCarNames(): List<String> {
    val allRacingCarNames: String = Console.readLine().replace("\\s".toRegex(), "")
    val result: List<String> = allRacingCarNames.split(",").distinct()

    require(!isOnlyBlankValidation(allRacingCarNames) &&
            !isOnlyOneValidation(result.toString())) {
        LACK_OF_CARS_ERROR_MESSAGE
    }
    require(isNameLengthBelowFiveValidation(result)) {
        TOO_LONG_CAR_NAME_ERROR_MESSAGE
    }

    return result
}

fun isOnlyBlankValidation(pureString: String): Boolean {
    return pureString.isBlank()
}

fun isOnlyOneValidation(pureString: String): Boolean {
    return pureString.split(",").size == 1
}

fun isNameLengthBelowFiveValidation(nameList: List<String>): Boolean {
    return nameList.all{it.length<=5}
}

fun isNumberTrialCountValidation(trialCount: Int?) : Boolean {
    return trialCount != null
}

fun runOneRound(CarNames: List<String>, moveResult: MutableList<String>): MutableList<String> {
    for(index in CarNames.indices) {
        val moveOrNot = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
        if(moveOrNot >= 4)
            moveResult[index] += "-"
    }
    return moveResult
}

fun printOneRound(CarNames: List<String>, moveResult: MutableList<String>) {
    for(index in CarNames.indices)
        println("${CarNames[index]} : ${moveResult[index]}")
}


fun getWinnerNames(carNames: List<String>, moveResult: MutableList<String>): String {
    val countOfMove = moveResult.map { it.length }
    val maxMoveLength = countOfMove.maxOrNull()
    val winnerList = mutableListOf<String>()

    for ((index, length) in countOfMove.withIndex()) {
        if (length == maxMoveLength) {
            winnerList.add(carNames[index])
        }
    }

    return winnerList.joinToString(", ")
}