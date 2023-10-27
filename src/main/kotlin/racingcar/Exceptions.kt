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
            for(i in name.indices){
                if(!name[i].isLetter()) throw IllegalArgumentException("Name should contains only letters.")
            }
        }
    }
}