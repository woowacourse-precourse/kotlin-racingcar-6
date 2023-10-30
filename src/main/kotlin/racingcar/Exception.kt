package racingcar

class Exception {
    fun nameValidation(name: List<String>) {
        name.forEach {
            if (it.length > 5) throw IllegalArgumentException("5글자를 초과할 수 없습니다.")
            if (it.isEmpty()) throw IllegalArgumentException("이름이 비어있습니다.")
        }
    }

    fun roundsValidation(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
        if (count < 0) throw IllegalArgumentException("0보다 작은 수는 입력할 수 없습니다.")
        return count
    }
}