package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val CAR_NAME_LIST = mutableListOf<String>()
val CAR_LIST = mutableListOf<Car>()
var MAX_DISTANCE = 0
val WINNER_LIST = mutableListOf<String>()

fun main() {
    initialize()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsName = Console.readLine()
    val names = carsName.split(',')
    for (name in names) {
        checkName(name)
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = Console.readLine()
    checkCount(count)

    Console.close()

    // CAR_NAME_LIST에 들어있는 이름으로 Car 객체를 만들어준다.
    for (name in CAR_NAME_LIST) {
        CAR_LIST.add(Car(name))
    }

    println()
    println("실행 결과")

    // count만큼 경주 게임을 시작한다.
    for (i in 0 until count.toInt()) {
        startGame()
    }

    // 최대 거리값을 구한다.
    for (item in CAR_LIST) {
        checkMaxDistance(item)
    }

    for (item in CAR_LIST) {
        checkisMaximum(item)
    }

    println("최종 우승자 : ${WINNER_LIST.joinToString()}")
}

fun initialize() {
    CAR_NAME_LIST.clear()
    CAR_LIST.clear()
    MAX_DISTANCE = 0
    WINNER_LIST.clear()
}

// 경주할 자동차 이름 글자 수 체크
fun checkName(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException()
    } else {
        CAR_NAME_LIST.add(name)
    }
}

// 시도 횟수 Int형 체크
fun checkCount(count: String) {
    try {
        count.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

// 경주 게임 시작
fun startGame() {
    for (item in CAR_LIST) {
        val random = Randoms.pickNumberInRange(0, 9)
        checkGo(item, random)
    }
    println()
}

// random 값을 확인하여 질주 체크
fun checkGo(item: Car, random: Int) {
    if (random >= 4) {
        item.goStraight()
    }
    println("${item.name} : ${"-".repeat(item.go)}")
}

// 거리 최대값을 구함
fun checkMaxDistance(item: Car) {
    if (item.go >= MAX_DISTANCE) {
        MAX_DISTANCE = item.go
    }
}

// 최대값과 객체의 go가 일치함 확인
fun checkisMaximum(item: Car) {
    if (item.go == MAX_DISTANCE) {
        WINNER_LIST.add(item.name)
    }
}