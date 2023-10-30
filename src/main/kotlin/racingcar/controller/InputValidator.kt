package racingcar.controller

class InputValidator {
    companion object {
        fun validateCarNameString(carNames: String): Boolean {
            val carNamesRegex = "^[0-9a-zA-Z][0-9a-zA-Z,]*[0-9a-zA-Z]\$".toRegex()

            if (!carNamesRegex.matches(carNames)) {
                return false
            }

            return true
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

        fun validateNumber(numString: String):Boolean{
            val checkNumRegex = "^[1-9]\\d*\$\n".toRegex()

            if (!checkNumRegex.matches(numString)) {
                return false
            }
            return true
        }
    }
}