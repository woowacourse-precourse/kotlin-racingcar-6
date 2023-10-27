package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val getNames = Console.readLine().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val peopleNum = getNames.size
    var trialCount = 0
    try {
        trialCount = Console.readLine().toInt()
    }
    catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }

    val cars = HashMap<String, String>()
    for (name in getNames) {
        if (name.length > 5) throw IllegalArgumentException()
        cars[name] = ""
    }

    println("\n실행 결과")
    repeat(trialCount) {
        for (name in cars.keys) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                cars[name] = cars[name]!! + "-"
            }
            println("$name : ${cars[name]}")
        }
        println()
    }

    var winner = mutableListOf<String>()
    var winnerScore: Int = 0
    for (name in cars.keys) {
        if (cars[name]?.length == winnerScore) {
            winner.add(name)
        }
        if (cars[name]?.length!! > winnerScore) {
            winnerScore = cars[name]?.length!!
            winner = mutableListOf<String>()
            winner.add(name)
        }
    }

    println("최종 우승자 : ${winner.joinToString(", ")}")
    Console.close()

}
