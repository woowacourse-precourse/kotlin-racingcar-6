package util

import constants.ErrorMessage

class Validator {
    fun checkCarName(name: String) {
        checkNameNull(name)
        checkNameSize(name)
        //Todo : 예외 처리_동명의 자동차
    }

    fun checkTryNum(num: String) {
        checkInputNull(num)
        checkTypeInt(num)
        checkTryNumSize(num)
    }

    fun checkInputNull(input: String){
        if(input.isEmpty()) throw IllegalArgumentException(ErrorMessage.INPUT_NULL)
    }

    private fun checkTypeInt(input: String) {
        if(input.chars().allMatch{ !Character.isDigit(it) }) throw IllegalArgumentException(ErrorMessage.INPUT_TYPE_BE_INT)
    }

    private fun checkNameNull(name: String) {
        if(name.isEmpty()) throw IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_NULL)
    }

    private fun checkNameSize(name: String) {
        if(name.length > NAME_MAX_LENGTH) throw IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_SIZE_OVER)
    }

    private fun checkTryNumSize(num: String) {
        if(num.toInt() < TRY_NUM_MIN_SIZE) throw IllegalArgumentException(ErrorMessage.INPUT_TRY_NUM_SIZE_UNDER)
        if(num.toInt() > TRY_NUM_MAX_SIZE) throw IllegalArgumentException(ErrorMessage.INPUT_TRY_NUM_SIZE_OVER)
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
        private const val TRY_NUM_MIN_SIZE = 1
        private const val TRY_NUM_MAX_SIZE = 100
    }
}