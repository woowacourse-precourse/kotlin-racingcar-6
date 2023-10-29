package racingcar

import camp.nextstep.edu.missionutils.Console

val CAR_NAME_LIST = mutableListOf<String>()
val CAR_LIST = mutableListOf<Car>()

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsName = Console.readLine()
    val names = carsName.split(',')
    for (name in names) {
        checkName(name)
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = Console.readLine()
    checkCount(count)

    // CAR_NAME_LIST에 들어있는 이름으로 Car 객체를 만들어준다.
    for (name in CAR_NAME_LIST) {
        CAR_LIST.add(Car(name))
    }
    
}

// 경주할 자동차 이름 글자 수 체크
fun checkName(name: String) {
    if (name.length > 4) {
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