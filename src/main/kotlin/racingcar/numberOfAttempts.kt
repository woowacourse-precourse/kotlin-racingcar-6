package racingcar

fun numberOfAttempts() : Int {                              // 시도 횟수
    println("시도할 횟수는 몇 회인가요?")
    val input = readLine() ?: (throw IllegalArgumentException())

    return input.toInt()
}