package view

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun requireCarNames(): List<String> {
        outputView.printRequireCarNames()
        return inputView.requireCarNames()
    }

    fun requireTryCnt(): Int {
        outputView.printRequireTry()
        return inputView.requireTryCnt()
    }
}