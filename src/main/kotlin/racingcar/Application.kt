package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val getNames = Console.readLine().split(",")
    val peopleNum = getNames.size
    var trialCount = 0
    try {
        trialCount = Console.readLine().toInt()
    }
    catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }

    val cars = HashMap<String, Int>()
    for (name in getNames) {
        if (name.length > 5) throw IllegalArgumentException()
        cars[name] = 0
    }

    repeat(trialCount) {
        for (name in cars.keys) {

        }
    }

}
