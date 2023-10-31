package racingcar.Utils

import racingcar.Utils.Constans.EXCEPTION_EXCEED_FIVE_LETTERS
import racingcar.Utils.Constans.EXCEPTION_NAME_CONTAINS_NON_LETTER
import racingcar.Utils.Constans.EXCEPTION_NUMBER_UNVALID

class Exceptions {
    companion object {
        fun checkNameListInput(list : List<String>){
            checkAllNameInFiveLetters(list)
            checkPossibleNames(list)
        }
        private fun checkAllNameInFiveLetters(list : List<String>) {
            require(list.all { it.length <= 5 }) { EXCEPTION_EXCEED_FIVE_LETTERS }
        }

        private fun checkPossibleNames(list : List<String>) {
            list.forEach {
                checkPossibleName(it)
            }
        }

        private fun checkPossibleName(name : String) {
            require(name.all { it.isLetter() }) { EXCEPTION_NAME_CONTAINS_NON_LETTER }
        }

        fun checkNumber(number : String) {
            require(number.all { it.isDigit() }) { EXCEPTION_NUMBER_UNVALID }
            //require(number.toLong() <= 1_000_000) { "불가능한 이동 횟수 입니다" }
            require(number.toInt() > 0) { "이동 횟수는 0보다 커야합니다." }
        }
    }
}