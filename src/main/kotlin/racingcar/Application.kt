package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

    val carList = getCars()

}

private fun getCars(): MutableList<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputNames = Console.readLine().split(",")
    val carList = mutableListOf<Car>()
    for (carName in inputNames) {
        if (carName.isEmpty() || carName.length > 5) {
            throw IllegalArgumentException()
        }
        carList.add(Car(name = carName))
    }

    return carList
}
