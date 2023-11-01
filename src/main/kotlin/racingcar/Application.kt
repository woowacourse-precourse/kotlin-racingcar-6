package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun allocRandom(carsNum: Int): Array<Int> {
    var randomNum = Array(carsNum) { 0 }
    for (i: Int in 0..carsNum - 1) {
        randomNum[i] = Randoms.pickNumberInRange(0, 9)
    }
    return randomNum
}

fun checkForward(randomNum: Array<Int>, result: Array<Int>) {
    for (i: Int in 0..randomNum.size - 1) {
        if (randomNum[i] >= 4) {
            result[i] += 1
        }
    }
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var cars = readLine()
    var car = cars?.split(",")
    if (car != null && car.size == 1) {
        throw IllegalArgumentException()
    }
    var carsNum = car!!.size
    for (i: Int in 0..carsNum - 1) {
        if (car[i].length > 5) {
            throw IllegalArgumentException()
        }
    }

    println("시도할 횟수는 몇 회인가요?")
    val move = readLine()?.toIntOrNull()
    if (move == null) {
        throw IllegalArgumentException()
    }
}
