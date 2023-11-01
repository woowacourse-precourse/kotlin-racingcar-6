package racingcar

class LoopCountExceptionChecker: ExceptionCheckerInterface {
    override fun check(input: String) {
        if(input.isEmpty()){
            throw IllegalArgumentException(Const.INPUT_EMPTY)
        }

        val isInputDigit = input.toList().all {
            it.isDigit()
        }

        if(isInputDigit.not()){
            throw IllegalArgumentException(Const.LOOP_COUNT_ERR_TYPE)
        }

        if(input.toInt() == 0){
            throw IllegalArgumentException(Const.LOOP_COUNT_ERR_ZERO)
        }
    }

}