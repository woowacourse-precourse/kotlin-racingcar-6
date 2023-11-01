package util

import constants.ErrorMessage

class Validator {

    fun checkInputNull(input: String?){
        if(input.isNullOrEmpty()) throw IllegalArgumentException(ErrorMessage.INPUT_NULL)
    }

    fun checkCarName(name: String) {
        checkNameNull(name)
        checkNameSize(name)
        //Todo : 예외 처리_동명의 자동차
    }

    private fun checkNameNull(name: String) {
        if(name.isEmpty())  throw IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_NULL)
    }

    private fun checkNameSize(name: String) {
        if(name.length > 5) throw IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_SIZE_OVER)
    }
}