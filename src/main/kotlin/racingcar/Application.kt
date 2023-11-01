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

    repeat( numberOfRounds ) {
        for ( item in carObjectList ) {
            item.moveCar()
            item.printLocation()

        }
        println("")

    }


    val maxList = mutableListOf<Int>()     // max의 값들을 모아놓는 리스트

    val originalMaxLocation = carObjectList.maxWith(Comparator.comparingInt { it.getLocation() })
    val originalMax = originalMaxLocation.getLocation()
    maxList.add(originalMax)
    // max값을 미리 추가해 둠으로써 뒤에 나올 반복문에서 do{}의 전체 내용이 최초 1회는 꼭 실행되도록 함.

    val winnerList = mutableListOf<String>()    // winner의 이름들을 모아놓는 리스트


    do {
        val maxLocation = carObjectList.maxWith(Comparator.comparingInt { it.getLocation() })
        // location 값이 가장 높은 객체를 반환
        val max = maxLocation.getLocation()    // 그 객체의 location 값을 max에 할당
        if (max !in maxList) {
            break
        }
        winnerList.add( maxLocation.getObjectName() )    // 그 객체의 이름을 winnerList에 추가)
        maxList.add(max)
        carObjectList.removeIf { it.getObjectName() in winnerList }  // 그 객체를 carObjectList에서 삭제

    } while ( (max in maxList) && (carObjectList.isNotEmpty()) )

    val result = winnerList.joinToString(", ")
    println("최종 우승자 : ${result}")















}

fun getUserInput(): Pair<List<String>, Int> {

    val carNameList: List<String> = Console.readLine().split(",")
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



