package racingcar

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.max

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

fun onRoundPlay(racingGame: LinkedHashMap<String, Int>): Int {
    var winnerPos = 0
    for (car in racingGame.keys) {
        if (isCarMove(car)) {
            racingGame[car] = (racingGame[car] ?: 0) + 1
        }
        winnerPos = max(winnerPos, (racingGame[car] ?: 0))
    }

    printRoundResult(racingGame)
    return winnerPos
}

fun runRacingGame(carList: List<String>, racingTime: Int) {
    val racingGame = LinkedHashMap<String, Int>()
    val sb = StringBuilder()
    var winnerPos = 0
    for (car in carList) {
        racingGame.put(car, 0)
    }

    repeat(racingTime) {
        winnerPos = onRoundPlay(racingGame)
    }

    sb.append("최종 우승자 : ")
    for (car in carList) {
        if (racingGame[car] == winnerPos) {
            sb.append(car)
            sb.append(", ")
        }
    }
    sb.deleteAt(sb.length-2)

    print(sb.toString())
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = readLine()!!.split(",")
    println("시도할 횟수는 몇 회인가요?")
    val racingTime = readLine()!!.toInt()
    println()
    runRacingGame(carList, racingTime)
}
