package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    // TODO: 프로그램 구현
    val tempPair = getUserInput()
    val carNameList = tempPair.first   // getUserInput()의 리턴 값은 ↓
    val numberOfRounds = tempPair.second    // ( carNameList, numberOfRounds )로 이루어진 Pair

    val carObjectList = mutableListOf<Car>()   // car 객체들을 담은 리스트 생성
    for ( carOwner in carNameList ) {   // 할당
        val car = Car(carOwner)
        carObjectList.add(car)

    }

}

fun getUserInput(): Pair<List<String>, Int> {

    val carNameList: List<String> = listOf(Console.readLine())
    val numberOfRounds = Console.readLine().toInt()

    return Pair(carNameList, numberOfRounds)
}

fun goOrStop(): Boolean {    // Car class의 인스턴스 함수가 사용한다.
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    var go = false

    if ( randomNumber >= 4 ) {
        go = true
    }

    return go
}



