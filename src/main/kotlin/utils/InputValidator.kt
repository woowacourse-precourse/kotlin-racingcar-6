package utils

import utils.Constants.EMPTY_STRING_ERR_MSG
import utils.Constants.NOT_NUMBER_ERR_MSG
import utils.Constants.STRING_LENGTH_ERR_MSG

object InputValidator {

    fun checkCarName(carNameList: List<String>) {
        carNameList.forEach { carName ->
            if (carName.isEmpty()) throw IllegalArgumentException(EMPTY_STRING_ERR_MSG)
            if (carName.length > 5) throw IllegalArgumentException(STRING_LENGTH_ERR_MSG)
        }
    }

    fun checkRoundCnt(input: String) {
        if (input.toIntOrNull() == null) throw IllegalArgumentException(NOT_NUMBER_ERR_MSG)
    }
}