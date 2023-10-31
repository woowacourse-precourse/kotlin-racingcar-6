package racingcar

import racingcar.Result

fun main() {
    val car = Car()
    val carList = car.makeCars()  // 차 이름 입력받기, 각 차에 대한 객체 생성

    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = readLine()?.toInt()  //TODO 숫자가 아닌 것을 입력 받을 경우 구현

    println("실행결과")
    val printResult = Try()
    printResult.goOrStop(tryNumber!!, carList)
    

}
