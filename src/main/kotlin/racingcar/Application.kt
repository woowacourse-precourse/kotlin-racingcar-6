package racingcar



fun main() {
    val carNames = inputCar()
    val tryNum = numberOfAttempts()
    val game = RacingCarGame(carNames)
    val carPositions = game.run(tryNum)
    winner(carPositions)
}
