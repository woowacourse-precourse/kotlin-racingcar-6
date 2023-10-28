package racingcar.exception

class Exception {
    fun checkSpaceInName(name: String) {
        val check = name.split(",")
        check.forEach {
            require(!it.contains(Regex("\\s"))) {
                "이름은 공백을 포함할 수 없습니다"
            }
        }
    }

    fun checkSpaceName(name: String) {
        val check = name.split(",")
        check.forEach {
            require(it.isNotBlank()) {
                "이름은 공백일 수 없습니다."
            }
        }
    }

    fun checkDuplicationName(name: String) {
        val check = name.split(",")
        require(check.toSet().size == check.size) {
            "중복된 이름입니다."
        }
    }

    fun checkLengthName(name: String) {
        val check = name.split(",")
        repeat(check.size) {
            require(check[it].length <= NAME_LENGTH) {
                "이름은 5자 이하만 가능합니다."
            }
        }
    }

    fun checkCycleString(number: String) {
        val length = number.length
        require(number.matches(Regex("[0-9]{$length}"))) {
            "숫자만 입력해 주세요."
        }
    }

    fun checkEmpty(text: String) {
        require(text.isNotEmpty()) {
            "값을 입력해주세요."
        }
    }

    companion object {
        private const val NAME_LENGTH = 5
    }
}