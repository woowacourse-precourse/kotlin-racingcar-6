package racingcar

import camp.nextstep.edu.missionutils.Console

val CAR_NAME_LIST = mutableListOf<String>()

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsName = Console.readLine()
    val names = carsName.split(',')
    for (name in names) {
        checkName(name)
    }
}

fun checkName(name: String) {
    if (name.length > 4) {
        throw IllegalArgumentException()
    } else {
        CAR_NAME_LIST.add(name)
    }
}