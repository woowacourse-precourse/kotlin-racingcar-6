package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStart()
}
fun gameStart(){
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carName = Console.readLine()
    val cars = carName.split(',')

    println("시도할 횟수는 몇 회인가요?")
    val repeat = Console.readLine().toInt()
}
