package racingcar

import java.lang.IllegalArgumentException

class Exceptions {
    companion object {
        fun checkNameListInput(list : List<String>){
            checkAllNameInFiveLetters(list)
            checkPossibleNames(list)
        }
        fun checkAllNameInFiveLetters(list : List<String>) {
            if(!list.all { it.length <= 5 }) throw IllegalArgumentException("Name Could not exceed 5 letters.")
        }

        fun checkPossibleNames(list : List<String>) {
            list.forEach {
                checkPossibleName(it)
            }
        }

        fun checkPossibleName(name : String) {
            require(!name.all { it.isLetter() }) { "Name should contains only letters." }
            //for(i in name.indices){
            //    if(!name[i].isLetter()) throw IllegalArgumentException()
            //}
        }

        fun checkNumber(number : String) {
            require(!number.all { it.isDigit() }) { "횟수는 숫자여야 합니다." }
        }
    }
}