package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStartMessage()

    getCarName()
}

fun gameStartMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun getCarName() {
    val inputCarName = Console.readLine()
    checkSoloCar(inputCarName)
}

private fun checkSoloCar(inputCarName: String): Boolean {
    if (!inputCarName.contains(",")) {
        soloCarGame(inputCarName)
    } else {
        val multiCarName = inputCarName.split(",")
        multiCarGame(multiCarName)
    }
    return true
}

fun soloCarGame(inputCarName: String) {
    var soloCount = 0
    repeat(2) {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        if (randomNum >= 4) {
            soloCount += 1
        }
    }

    if (soloCount >= 1) {
        soloChampion(inputCarName)
    }
}

fun multiCarGame(multiCarName: List<String>) {
}

fun soloChampion(carName: String) {
    println("최종 우승자 : $carName")
}
