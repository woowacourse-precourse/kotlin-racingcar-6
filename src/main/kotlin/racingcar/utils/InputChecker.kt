package racingcar.utils

class InputChecker {

    companion object {
        const val INPUT_NAME = "이름을 입력해야 합니다."
        const val INPUT_UNDER_FIVE = "이름을 5자 이하로 입력해야 합니다."
    }

    fun checkInputNames(names: List<String>) {
        names.forEach { name ->
            if (name.isEmpty()) throw IllegalArgumentException(INPUT_NAME)
            if (name.length > 5) throw IllegalArgumentException(INPUT_UNDER_FIVE)
        }
    }
}