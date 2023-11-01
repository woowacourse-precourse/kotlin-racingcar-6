package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val gamee = Randoms.pickNumberInRange(0, 9)
    val read = Console.readLine()
    println(gamee)
    println(read)
}
