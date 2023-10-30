package racingcar.view

class TestOutputView : OutputView {
    private val _capturedTexts = mutableListOf<String>()
    val capturedTexts: List<String> get() = _capturedTexts
    override fun displayText(text: String) {
        _capturedTexts.add(text)
    }
}