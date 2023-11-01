package racingcar

fun main() {
    try {
        PrintUtils.printIntroduction()

        val carNames = readLine()?.split(",")?.map { it.trim() }

        PrintUtils.printTryCount()

        val tryCount = readLine()?.toIntOrNull()

        if (carNames == null || tryCount == null || carNames.isEmpty()) {
            throw IllegalArgumentException("입력값이 올바르지 않습니다.")
        }

        val cars = carNames.map { Car(it) }
        val racingGame = RacingGame(cars, tryCount)

        racingGame.playGame()

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
