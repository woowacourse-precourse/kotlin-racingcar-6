package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    runGame()
}

const val CAR_NAME_LENGTH = 5
fun runGame() {
    val setCars: MutableList<String> = mutableListOf()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    try {
        val carName = getCarNames()
        val carNameList = carName.split(",").map { it.trim() }
        for (car in carNameList) {
            if (car.length <= CAR_NAME_LENGTH) {
                setCars.add(car)
            } else {
                throw IllegalArgumentException("자동차 이름은 5자 이하로 설정해주세요.")
            }
        }
        println(setCars)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
fun getCarNames(): String {
    return Console.readLine() ?: ""
}