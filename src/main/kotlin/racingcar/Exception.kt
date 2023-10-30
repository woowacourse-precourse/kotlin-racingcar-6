package racingcar

class Exception {
    fun nameValidation(name: List<String>) {
        name.forEach {
            if (it.length > 5) throw IllegalArgumentException("5글자를 초과할 수 없습니다.")
            if (it.isEmpty()) throw IllegalArgumentException("이름이 비어있습니다.")
        }
    }
}