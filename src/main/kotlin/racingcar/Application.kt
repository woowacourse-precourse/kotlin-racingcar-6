package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val carGame = Console.readLine()
    val test = Randoms.pickNumberInRange(0, 9)

    println(carGame)
    println(test)
    Console.close()
}
