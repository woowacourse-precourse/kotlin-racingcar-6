package racingcar

class ExceptionManager {
    fun nameException(name: List<String>) {
        for (index in name) {
            if (index.length > 5) {
                throw IllegalArgumentException("이름을 5자 이하로 입력해주세요")
            }
        }
        if (name[0].isEmpty()) {
            throw IllegalArgumentException("이름을 입력해주세요")
        }
        if (name.distinct().size != name.size) {
            throw IllegalArgumentException("동일한 이름이 중복되었습니다.")
        }
        if (name.lastOrNull().isNullOrBlank()) {
            throw IllegalArgumentException("마지막 이름을 입력해주세요.")
        }
    }

    fun repeatException(num: String) {
        val repeatNum = num.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
        if (repeatNum < 1) {
            throw IllegalArgumentException("1 이상의 숫자를 입력해주세요")
        }
    }
}