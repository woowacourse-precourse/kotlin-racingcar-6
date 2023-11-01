package racingcar

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var cars = readLine()
    var car = cars?.split(",")
    if (car != null && car.size == 1) {
        throw IllegalArgumentException()
    }
    var carsNum = car!!.size
    for (i: Int in 0..carsNum - 1) {
        if (car[i].length > 5) {
            throw IllegalArgumentException()
        }
    }

    println("시도할 횟수는 몇 회인가요?")
    val move = readLine()?.toIntOrNull()
    if (move == null) {
        throw IllegalArgumentException()
    }
}
