package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun isCarMove(car: String): Boolean {
    val dice = Randoms.pickNumberInRange(0, 9)
    return dice >= 4
}


fun printRoundResult(racingGame: LinkedHashMap<String, Int>) {
    for (car in racingGame.keys) {
        val sb = StringBuilder()
        sb.append("${car} : ")
        racingGame[car]?.let {
            repeat(it) {
                sb.append("-")
            }
        }
        println(sb.toString())
    }
    println()
}

fun onRoundPlay(racingGame: LinkedHashMap<String, Int>) {
    for (car in racingGame.keys) {
        if (isCarMove(car)) {
            racingGame[car] = (racingGame[car] ?: 0) + 1
        }
    }

    printRoundResult(racingGame)
}

fun runRacingGame(carList: List<String>, racingTime: Int) {
    val racingGame = LinkedHashMap<String, Int>()
    for (car in carList) {
        racingGame.put(car, 0)
    }

    repeat(racingTime) {
        onRoundPlay(racingGame)
    }
}

fun main() {
    val carList = readLine()!!.split(",")
    val racingTime = readLine()!!.toInt()
    runRacingGame(carList, racingTime)
}
