package racingcar.controller

class InputValidator {
    companion object {
        fun validateCarNameString(carNames: String): Boolean {
            val carNamesRegex = "^[0-9a-zA-Z][0-9a-zA-Z,]*[0-9a-zA-Z]\$".toRegex()

            return carNamesRegex.matches(carNames)
        }

        fun validateCarName(carNameList: List<String>): Boolean {
            val carNameRegex = "^[0-9a-zA-Z]{1,5}\$".toRegex()

            for (carName in carNameList) {
                if (!carNameRegex.matches(carName)) {
                    return false
                }
            }
            return true
        }

        fun validateNumber(numString: String): Boolean {
            if (!numString.all { it.isDigit() }) {
                return false
            }
            val num = numString.toInt()

            return num > 0
        }
    }
}