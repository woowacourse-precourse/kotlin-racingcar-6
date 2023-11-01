package view

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun requireCarNames(): List<String>{
        outputView.requireCarNames()
        return inputView.requireCarNames()
    }
}