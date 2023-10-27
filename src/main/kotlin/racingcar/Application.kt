package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carList = makeCarList(getCarName())
}

// 기능 1. 자동차 이름 입력받기
fun getCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNameInputList = Console.readLine()

    return carNameInputList.split(",")
}

// 기능 2. 자동차 리스트 만들기
fun makeCarList(carNameList: List<String>): List<Car> {
    val carList = mutableListOf<Car>()
    for(name in carNameList) {
        carList.add(Car(name))
    }

    return carList
}