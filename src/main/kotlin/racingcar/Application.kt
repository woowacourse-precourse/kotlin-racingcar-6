package racingcar

fun main() {
    try {
        // TODO: 프로그램 구현
        val racingManager = RacingManager()
        racingManager.startGame()
        racingManager.findWinner()
    } catch (e: IllegalArgumentException) {
        println("\nError : ${e.message}")
    }
}
