package racingcar.io

class UserInterface(
    private val output: Output = Output(),
    private val input: Input = Input()
) {
    fun enterCarNames(): List<String> {
        output.askCarNames()

        return input.enterCarNames()
    }

    fun enterTryNumbers(): Int {
        output.askTryNumber()

        return input.enterTryNumber()
    }
}