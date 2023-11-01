package racingcar

fun main() {
    val (carNameMap, tryCount) = getRacingInput()
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