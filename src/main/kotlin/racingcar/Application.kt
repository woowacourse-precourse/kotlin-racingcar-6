package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {

}

fun inputCar(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine()!!    // 그냥 엔터를 쳤을때는?
    val carNames = input.split(",").map{ it.trim() } // 각 문자열 공백 제거

    carNames.forEach{
        if(it.length > 5) throw IllegalArgumentException()
    }

    return carNames
}
fun numberOfAttempts() : Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = readLine()?:(throw IllegalArgumentException())
    return input.toInt()
}


