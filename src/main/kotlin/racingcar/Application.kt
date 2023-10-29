package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    runGame()
}

const val CAR_NAME_LENGTH = 5
fun runGame() {

    val carName = getCarNames()
    val tryNumber = getTryNumbers()

}
fun getCarNames(): List<String> {
    val carNameList: MutableList<String> = mutableListOf()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return try {
        val carName = Console.readLine() ?: ""
        val carNames = carName.split(",").map { it.trim() }
        for (car in carNames) {
            if (car.length <= CAR_NAME_LENGTH) {
                carNameList.add(car)
            } else {
                throw IllegalArgumentException("자동차 이름은 5자 이하로 설정해주세요.")
            }
        }
        carNameList
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("잘못된 입력입니다 : ${e.message}")
    }
}

fun getTryNumbers(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return try {
        val tryNumber = Console.readLine()?.toInt() ?: 0
        if (tryNumber <= 0) {
            throw IllegalArgumentException("양의 정수를 입력해주세요.")
        }
        tryNumber
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("잘못된 입력입니다 : ${e.message}")
    }
}