package racingcar.exception

const val MAX_NAME_SIZE = 5

class ExceptionChecker {

    fun checkCarNames(carNames: List<String>) {
        checkNameSize(carNames)
        checkIsNameBlank(carNames)
    }
    private fun checkNameSize(carNames: List<String>) {

        for (name in carNames) {
            if (name.isEmpty() || name.length > MAX_NAME_SIZE) {
                throw IllegalArgumentException("[ERROR] 올바른 이름 사이즈가 아닙니다.")
            }
        }
    }
    private fun checkIsNameBlank(carNames: List<String>) {
        for(name in carNames) {
            if (name.isBlank()) {
                throw IllegalArgumentException("[ERROR] 공백만 입력하셨어요.")
            }
        }
    }
}