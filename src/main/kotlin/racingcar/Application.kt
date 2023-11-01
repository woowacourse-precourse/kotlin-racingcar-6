package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    var racingCarNames: List<String>
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    racingCarNames = getRacingCarNames()
    println("시도할 횟수는 몇 회인가요?")
    val trialCount: Int = Console.readLine().toInt()

    println("실행 결과")
    repeat(trialCount){

    }
}

fun getRacingCarNames(): List<String> {
    val allRacingCarNames: String = Console.readLine().replace("\\s".toRegex(), "")
    val result: List<String> = allRacingCarNames.split(",").distinct()

    require(isOnlyBlankValidation(allRacingCarNames) ||
            isOnlyOneValidation(result.toString())) {
        "경주할 자동차 이름을 두 대 이상 입력하세요"
    }
    require(isNameLongerThanFiveValidation(result)) {
        "자동차 이름은 5자 이하만 가능합니다"
    }

    return result
}

fun isOnlyBlankValidation(pureString: String): Boolean {
    return pureString.isBlank()
}

fun isOnlyOneValidation(pureString: String): Boolean {
    return pureString.split(",").size == 1
}

fun isNameLongerThanFiveValidation(nameList: List<String>): Boolean {
    return nameList.all{it.length<=5}
}