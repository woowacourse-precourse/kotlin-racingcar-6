package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현

    val racingInfo = beforeRacing()  // racingInfo(rmation) : carList와 numberOfRounds로 이루어진 Pair
    print(racingInfo)

}

fun beforeRacing(): Pair<List<String>, Int> {

    val carList: List<String> = listOf(Console.readLine())
    val numberOfRounds = Console.readLine().toInt()

    return Pair(carList, numberOfRounds)
}

