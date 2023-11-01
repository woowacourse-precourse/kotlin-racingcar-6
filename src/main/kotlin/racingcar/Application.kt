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
    calculateFinalWinner(carNameMap)
}

fun calculateFinalWinner(carNameMap: MutableMap<String, String>) {
    val maxLength = carNameMap.values.map { it.length }.maxOrNull()
    val winner = carNameMap.filter { it.value.length == maxLength }.keys.toList()
    if (winner.size == 1) {
        print("최종 우승자 : ${winner[0]}")
    } else {
        print("최종 우승자 : ${winner.joinToString(", ")}")
    }
}
