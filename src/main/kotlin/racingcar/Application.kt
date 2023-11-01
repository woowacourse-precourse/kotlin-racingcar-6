package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현


}

fun beforeRacing(): Pair<List<String>, Int> {

    val carNameList: List<String> = listOf(Console.readLine())
    val numberOfRounds = Console.readLine().toInt()

    return Pair(carNameList, numberOfRounds)
}

fun goOrStop(): Boolean {   // Car class의 인스턴스 함수가 사용한다.
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    var go = false

    if ( randomNumber >= 4 ) {
        go = true
    }

    return go
}



