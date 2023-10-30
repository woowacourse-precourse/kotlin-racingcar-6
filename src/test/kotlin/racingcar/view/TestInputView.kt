package racingcar.view

class TestInputView : InputView {
    private val userInputList = mutableListOf<String>()
    override fun readLine(): String {
        return userInputList.removeFirst()
    }

    override fun readInt(): Int {
        return requireNotNull(readLine().toIntOrNull())
    }

    fun addUserInput(vararg input: String) {
        userInputList.addAll(input)
    }
}