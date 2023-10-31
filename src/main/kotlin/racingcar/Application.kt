package racingcar

import camp.nextstep.edu.missionutils.Randoms


const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
fun main() {
    // TODO: 프로그램 구현

}



fun move(car: generateCars): Int {
    if (Randoms.pickNumberInRange(0, 9) >= 4) moveForward()
}

fun moveForward(randomNumber: Int): Boolean {
    var position: Int = 0
    position++
    return position

}

fun race() {
    val roundTimes = getAttemptTimes()
    repeat(roundTimes) { playRound() }
}

fun playRound(cars: List<generateCars>) {
    cars.forEach {
        move(it)
    }
}
