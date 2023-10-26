package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val carList = getCars()
    val times = getTimes()

    startRacing(times, carList)
}

private fun startRacing(times: Int, carList: MutableList<Car>) {
    print("\n실행 결과")
    for (index in 0 until times) {
        moveForwardForAllCars(carList)
        printSubResult(carList)
    }
}

private fun printSubResult(carList: MutableList<Car>) {
    for (car in carList) {
        println(car)
    }
    println()
}

private fun moveForwardForAllCars(carList: MutableList<Car>) {
    for (car in carList) {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        moveForward(car, randomNum)
    }
}

private fun moveForward(car: Car, randomNum: Int) {
    if (randomNum >= 4) {
        car.cntForwards++
    }
}

private fun getTimes(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val inputTimes = Console.readLine()
    try {
        return inputTimes.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
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
