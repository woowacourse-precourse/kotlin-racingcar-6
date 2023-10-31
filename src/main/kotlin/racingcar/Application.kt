package racingcar

fun main() {
    val car = Car()
    val carList = car.makeCars()  // 차 이름 입력받기, 각 차에 대한 객체 생성

    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = readLine()?.toInt()  //TODO 숫자가 아닌 것을 입력 받을 경우 구현
    val attempts = Try()
    attempts.goOrStop(tryNumber!!, carList)

    //val tryNumber = Try()
    //val input = tryNumber.tryNumberInput()  // 시도할 횟수 입력받기

    //val result = Result()
    //result.printResult(input, carList)  // 시도할 횟수만큼 반복

}
