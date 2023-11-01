package service

object ExceptionHandler {
    // 자동차 이름 입력 시 알파벳, 숫자, 쉼표만 입력했는지 확인
    fun checkNames(names: String) : Boolean {
        for (i in names) {
            if (!(i.isLetter() || i == ','|| i.isDigit())) {
                throw IllegalArgumentException("[ERROR]")
            }
        }
        return true
    }

    // 이름의 길이가 1~5자 인지 확인
    fun checkNameLength(name: String) {
        if (name.length < 1 || name.length > 5) {
            throw IllegalArgumentException("[ERROR]")
        }
    }

    // 시도할 회수에 숫자가 들어왔는지 확인
    fun checkValidCount(count: String): Boolean {
        val intValue = count.toIntOrNull()
        if (intValue == null || intValue <= 0) {
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

}
