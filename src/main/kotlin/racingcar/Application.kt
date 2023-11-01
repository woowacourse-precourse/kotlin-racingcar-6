package racingcar

fun main() {
    try {
        PrintUtils.printIntroduction()

        val carNames = readLine()?.split(",")?.map { it.trim() }

        if (carNames.isNullOrEmpty() || !carNames.all { it.length <= 5 }) {
            throw IllegalArgumentException("입력값이 올바르지 않습니다.")
        }

        PrintUtils.printTryCount()

        val tryCount = readLine()?.toIntOrNull()

        if (tryCount == null || tryCount <= 0) {
            throw IllegalArgumentException("입력값이 올바르지 않습니다.")
        }

        val cars = carNames.map { Car(it) }
        val racingGame = RacingGame(cars, tryCount)

        racingGame.playGame()

    } catch (e: IllegalArgumentException) {
        println(e.message) // 예외 메시지를 출력
        throw e // 예외를 다시 던짐
    }
}
