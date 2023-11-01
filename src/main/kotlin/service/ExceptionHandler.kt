package service

object ExceptionHandler {
    // 자동차 이름 입력 시 알파벳과 쉼표만 입력했는지 확인
    fun checkNames(names: String) : Boolean {
        for (i in names) {
            if (!(i in 'A'..'Z' || i in 'a'..'z' || i == ',')) {
                throw IllegalArgumentException("[ERROR]")
            }
        }
        return true
    }

    // 이름의 길이가 5자 이하인지 확인
    fun checkNameLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("[ERROR]")
        }
    }

    // 시도할 회수에 숫자가 들어왔는지 확인
    fun checkValidCount(count: String): Boolean {
        val intValue = count.toIntOrNull()
        if (intValue == null) {
            throw IllegalArgumentException("[ERROR]")
        }
        return true
    }

    // 입력값이 없는지 확인
    fun checkNotEmpty(value: String): Boolean {
        if (value.isEmpty()) {
            throw IllegalArgumentException("[ERROR]")
        }
        return true
    }

    // 중복된 이름 확인
    fun checkDuplicateNames(names: String): Boolean {
        val nameList = names.split(",")
        val distinctNames = nameList.distinct()
        if (nameList.size != distinctNames.size) {
            throw IllegalArgumentException("[ERROR]")
        }
        return true
    }

    // 음수 확인
    fun checkNonNegativeNumber(number: String): Boolean {
        val intValue = number.toIntOrNull()
        if (intValue == null) {
            throw IllegalArgumentException("[ERROR]")
        }
        if (intValue < 0) {
            throw IllegalArgumentException("[ERROR]")
        }
        return true
    }
}
