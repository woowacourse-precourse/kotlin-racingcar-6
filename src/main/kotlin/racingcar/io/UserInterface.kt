package racingcar.io

class UserInterface(
    private val output: Output = Output(),
    private val input: Input = Input()
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