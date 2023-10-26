package racingcar

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carname = readLine()
    val cars = carname?.split(",")
    println("시도할 횟수는 몇 회인가요?")
    val numoftry = readLine()
}
