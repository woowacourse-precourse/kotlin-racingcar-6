package racingcar.view

class TestInputView : InputView {
    private val userInputList = mutableListOf<String>()
    override fun readLine(): String {
        return userInputList.removeFirst()
    }

    override fun readInt(): Int {
        return requireNotNull(readLine().toIntOrNull()) { INPUT_NOT_NUMBER_EXCEPTION }
    }

    fun addUserInput(vararg input: String) {
        userInputList.addAll(input)
    }

    companion object {
        const val INPUT_NOT_NUMBER_EXCEPTION = "Input must be a number"
    }
}