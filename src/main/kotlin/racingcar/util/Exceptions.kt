package racingcar.util

object Exceptions {

    // 5자 이하, 두대 이상의 이름이 들어오지 않았을 경우 예외처리
    fun validateCarNamesInput(input: String?) {
        if (input == null) {
            throwIllegalArgumentException()
        }else{
            val carNames = input.split(",").map { it.trim() }

            if (carNames.any { it.isBlank() || it.length > 5 } || carNames.size <2) {
                throwIllegalArgumentException()
            }
        }
    }

    // 1이상의 Int값이 아닐 경우 예외처리
    fun validateRoundsInput(inputRounds: String?) {
        if (inputRounds == null || ! inputRounds.all{it.isDigit()} || inputRounds.toInt() == 0) {
            throwIllegalArgumentException()
        }
    }

    // IllegalArgumentException
    private fun throwIllegalArgumentException(){
        throw IllegalArgumentException(CommonStrings.ILLEGAL_ARGUMENT_EXCEPTION)
    }

}