package racingcar.view

class ConsoleOutputView : OutputView {
    override fun displayText(text: String) {
        println(text)
    }
}