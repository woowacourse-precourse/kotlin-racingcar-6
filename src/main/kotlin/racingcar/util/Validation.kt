package racingcar.util

import racingcar.util.Constants.INPUT_NAME_ERROR
import racingcar.util.Constants.INPUT_NUM_ERROR

object Validation {

    fun validateName(cars : List<String>) {
        cars.forEach{
            if(it.length > 5 || it.isEmpty()) throw IllegalArgumentException(INPUT_NAME_ERROR)
        }
    }

    fun validateNum(num : String){
        if(!num.all { it.isDigit() } || num.toInt() <= 0 || num.isEmpty()) {
            throw IllegalArgumentException(INPUT_NUM_ERROR)
        }
    }
}