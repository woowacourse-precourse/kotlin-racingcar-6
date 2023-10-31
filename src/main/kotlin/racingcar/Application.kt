package racingcar

fun main() {
    // TODO: 프로그램 구현
    val carsName = inputCarsName()
    println(carsName)
}

fun inputCarsName() : String{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readLine().toString()
}