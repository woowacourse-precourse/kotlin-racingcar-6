package racingcar.exception

class NameValidation(private val input: String) : Exception {
    private val names: List<String> = input.split(",")

    init {
        checkEmpty()
        checkSpaceName()
        checkSpaceInName()
        checkDuplicationName()
        checkLengthName()
    }

    private fun checkSpaceInName() {
        names.forEach {
            require(!it.contains(Regex("\\s"))) {
                "이름은 공백을 포함할 수 없습니다"
            }
        }
    }

    private fun checkSpaceName() {
        names.forEach {
            require(it.isNotBlank()) {
                "이름은 공백일 수 없습니다."
            }
        }
    }

    private fun checkDuplicationName() {
        require(names.toSet().size == names.size) {
            "중복된 이름입니다."
        }
    }

    private fun checkLengthName() {
        repeat(names.size) {
            require(names[it].length <= MAX_NAME_LENGTH) {
                "이름은 ${MAX_NAME_LENGTH}자 이하만 가능합니다."
            }
        }
    }

    override fun checkEmpty() {
        require(input.isNotEmpty()) {
            "값을 입력해주세요."
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}