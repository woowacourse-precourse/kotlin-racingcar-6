package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car

fun main() {
    var carNames: MutableList<Car> = mutableListOf()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    carNames = askCarName(carNames, input)
}

fun askCarName(carNames: MutableList<Car>, input: String): MutableList<Car> {
    val carNameList = input.split(",")
    for (carName in carNameList) {
        if (carName.length > 5)
            throw IllegalArgumentException("String index out of range: 5")
        carNames.add(Car(carName))
    }
    return carNames
}

fun askNumber() {

}

fun printWinner() {

}