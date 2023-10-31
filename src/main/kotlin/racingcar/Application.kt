package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val nameList = Ask().carNames()
    val moveNumList = MoveCars(nameList, Ask().tryNum()).repeatMove()
    Winner(nameList, moveNumList).who()
}

