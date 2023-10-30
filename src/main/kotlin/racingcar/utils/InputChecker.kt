package racingcar.utils

// 입력값을 확인하고 오류가 없다면 타입을 바꿔서 반환하는 클래스
class InputChecker {

    companion object {
        const val INPUT_NAME = "이름을 입력해야 합니다."
        const val INPUT_UNDER_FIVE = "이름을 5자 이하로 입력해야 합니다."
        const val INPUT_ONLY_NUMBER = "숫자만 입력해야 합니다."
    }

    fun checkInputNames(names: String): List<String> {
        return names.split(",").map { name ->
            if (name.isEmpty()) throw IllegalArgumentException(INPUT_NAME)
            if (name.length > 5) throw IllegalArgumentException(INPUT_UNDER_FIVE)
            name
        }
    }

    fun checkMoveTimes(moveTimes: String): Int {
        if (!Regex("\\d+").matches(moveTimes)) throw IllegalArgumentException(INPUT_ONLY_NUMBER)
        return moveTimes.toInt()
    }
}