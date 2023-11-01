package domain

import domain.Constant.CAR_NAME_MAX
import domain.Constant.MAX_NUM_RANGE_ASCII
import domain.Constant.MIN_NUM_RANGE_ASCII
import domain.Constant.NO_EXIST_INPUT_EXCEPTION
import domain.Constant.WRONG_NAME_LENGTH_EXCEPTION
import domain.Constant.WRONG_NOTATION_EXCEPTION
import domain.Constant.WRONG_NUM_EXCEPTION

class Exception {
    fun wrongNameException(inputName: String) {
        if (inputName.isEmpty()) throw IllegalArgumentException(NO_EXIST_INPUT_EXCEPTION)
    }

    fun nameLengthException(inputName: String) {
        val name = inputName.split(",")
        for (index in name.indices) {
            if (name[index].length > CAR_NAME_MAX) throw IllegalArgumentException(WRONG_NAME_LENGTH_EXCEPTION)
        }
    }

    fun nameNotationException(inputName: String) {
        if (!inputName.contains(",")) throw IllegalArgumentException(WRONG_NOTATION_EXCEPTION)
    }

    fun wrongNumException(inputNum: String) {
        if (!isNum(inputNum)) throw IllegalArgumentException(WRONG_NUM_EXCEPTION)
    }

    fun isNum(answer: String): Boolean {
        answer.forEach { char ->
            val charConvertToInt = char.digitToIntOrNull()
            val charConvertToCode = char.code
            if (charConvertToCode > MAX_NUM_RANGE_ASCII || charConvertToCode < MIN_NUM_RANGE_ASCII) {
                throw IllegalArgumentException(WRONG_NUM_EXCEPTION)
            }
            if (charConvertToInt == null) {
                throw IllegalArgumentException(NO_EXIST_INPUT_EXCEPTION)
            }
        }
        return true
    }
}