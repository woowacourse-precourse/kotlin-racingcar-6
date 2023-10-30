package racingcar

fun main() {
    val car = Car()
    car.makeCars()  // 차 이름 입력받기

    val tryNumber = Try()
    val input = tryNumber.tryNumberInput()  // 시도할 횟수 입력받기

    val result = Result()
    result.printResult(input)  // 시도할 횟수만큼 반복
}
