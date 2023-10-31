package racingcar

fun main() {
    val racing = Racing()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = readLine()!!.split(",")
    carNames.forEach { racing.addCar(it) }

    println("시도할 횟수는 몇 회인가요?")
    val count = readLine()!!.toInt()
    racing.gameCount(count)

    val winners = racing.getWinner()

    println("실행 결과")
    repeat(count) {
        racing.getCars().forEach { car ->
            car.printStatus()
        }
        println()
    }
    if (winners.size > 1) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
    if (winners.size == 1) {
        println("최종 우승자 : ${winners[0]}")
    }
}
