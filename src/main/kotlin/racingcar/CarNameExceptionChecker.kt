package racingcar

class CarNameExceptionChecker : ExceptionCheckerInterface {
    override fun check(input: String) {
        if(input.isEmpty()){
            throw IllegalArgumentException(Const.INPUT_EMPTY)
        }

        val inputCharList = input.toList()
        val nameChecker = inputCharList.all {
            it.isLetterOrDigit() || it == ','
        }
        if(nameChecker.not()){
            throw IllegalArgumentException(Const.CAR_NAME_ERR_TYPE)
        }

        val nameList = input.split(",")
        val nameDuplicate = nameList.distinct()
        if(nameDuplicate.size != nameList.size){
            throw IllegalArgumentException(Const.CAR_NAME_ERR_DUP)
        }

        val nameLenChecker = nameList.all {
            it.length in 1..5
        }

        if(nameLenChecker.not()){
            throw IllegalArgumentException(Const.CAR_NAME_ERR_LEN)
        }
    }
}