package racingcar

import Logic.Logic
import User.User

fun main() {
    // TODO: 프로그램 구현
    val user = User()
    val logic = Logic()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userCount = user.inputCarName()
    logic.makeCarDistanceList(userCount)

    println("시도할 횟수는 몇 회인가요?")
    var cycleNumber = user.inputCycleNumber()
    for(i in 0..cycleNumber-1){
        logic.moveCar()
    }
}
