package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val listOfCar = Console.readLine()
        .split(',')
}
