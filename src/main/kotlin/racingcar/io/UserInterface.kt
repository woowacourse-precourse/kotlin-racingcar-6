package racingcar.io

class UserInterface(
    val output: Output = Output(),
    val input: Input = Input()
) {
    fun enterCarNames(): List<String> {
        output.askCarNames()
        val carNames = input.enterCarNames()

        return carNames
    }

    fun enterTryNumbers(): Int {
        output.askTryNumber()
        val tryNumber = input.enterTryNumber()

        return tryNumber
    }
}