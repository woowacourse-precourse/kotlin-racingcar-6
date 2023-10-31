package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val nameList = Ask().carNames()
    val numList = MoveCars(nameList, Ask().tryNum()).repeatMove()
    Winner(nameList, numList).who()
}

