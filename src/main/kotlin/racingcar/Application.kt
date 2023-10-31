package racingcar

import racingcar.Result

fun main() {
    val car = Car()
    val carList = car.makeCars()  // 각 차에 대한 객체 생성

    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = readLine()?.toInt()

    println("실행결과")
    val printResult = Try()
    printResult.goOrStop(tryNumber!!, carList)

    print("최종 우승자 : ")
    val winner = Result()
    winner.printWinner(carList)
}
