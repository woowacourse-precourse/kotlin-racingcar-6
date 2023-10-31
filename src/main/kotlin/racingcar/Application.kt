package racingcar

import Logic.Logic
import User.User

fun main() {
    // TODO: 프로그램 구현
    val user = User()
    val logic = Logic()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNameList = user.inputCarName()
    val userCount = carNameList.size
    val carDistanceList = logic.makeCarDistanceList(userCount)

    println("시도할 횟수는 몇 회인가요?")
    var cycleNumber = user.inputCycleNumber()

    println("실행 결과")
    for(i in 0..cycleNumber-1){
        logic.moveCar(carDistanceList)
        user.printCarInfo(carDistanceList, carNameList)
        println()
    }

    print("최종 우승자 : " + user.printCarNameOfMaxDistance(carDistanceList, carNameList))

}
