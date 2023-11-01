package racingcar

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val (carNameMap, tryCount) = getRacingInput()
    playRacingGame(carNameMap, tryCount)
}

fun getRacingInput(): Pair<MutableMap<String, String>, Int> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = readLine().toString().split(",")
    val carNameMap: MutableMap<String, String> = mutableMapOf()

    for (carName in carNames) {
        if (carName.length > 5) throw IllegalArgumentException()
        carNameMap[carName] = ""
    }

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readLine()!!.toInt()

    return Pair(carNameMap, tryCount)
}

fun playRacingGame(carNameMap: MutableMap<String, String>, tryCount: Int) {
    println("실행 결과")
    repeat(tryCount) {
        for ((key, value) in carNameMap) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carNameMap[key] = value + "-"
            }
            println("${key} : ${carNameMap[key]}")
        }
        println()
    }
}
