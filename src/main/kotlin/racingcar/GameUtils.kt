package racingcar

object GameUtils {
    fun checkValidInput(condition: () -> Boolean) {
        if (!condition()) {
            onWrongInput()
        }
    }

    fun onWrongInput(): Nothing {
        throw IllegalArgumentException("잘못된 입력입니다")
    }
}