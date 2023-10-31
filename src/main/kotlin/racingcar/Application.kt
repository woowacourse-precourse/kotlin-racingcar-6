package racingcar

fun main() {
    val racingCarController = RacingCarController(InputView(), OutputView())
    racingCarController.run()
}