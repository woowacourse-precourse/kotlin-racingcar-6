package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun isCarMove(car: String): Boolean {
    val dice = Randoms.pickNumberInRange(0, 9)
    return dice >= 4
}

fun runRacingGame(carList: List<String>, racingTime: Int) {
    val racingGame = LinkedHashMap<String, Int>()
    for (car in carList) {
        racingGame.put(car, 0)
    }

}

fun main() {
    // TODO: 프로그램 구현
    val carList = readLine()!!.split(", ")
    val racingTime = readLine()!!.toInt()
}
