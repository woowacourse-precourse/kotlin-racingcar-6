package racingcar


fun main() {
    // TODO : 자동차 이름 입력받기 (,로 구분)
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var input: String = readLine() ?: throw IllegalArgumentException()
    var cars = input.split(',')

    println(cars)

    // TODO : 시도할 횟수 입력받기
    println("시도할 횟수는 몇 회인가요?")
    var tries: Int = readLine()?.toInt() ?: throw IllegalArgumentException()

    println(tries)
}
