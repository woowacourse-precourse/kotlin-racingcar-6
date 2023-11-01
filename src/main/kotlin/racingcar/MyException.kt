package racingcar

class MyException {
    fun throwNameEmptyException(input:String){
        if(input == ""){
            throw IllegalArgumentException()
        }
    }
    fun throwNameOverFiveException(input: String){
        if(input.length > 5){
            throw IllegalArgumentException()
        }
    }

    fun throwRepeatStringException(input:String){
        try{
            input.toInt()
        }catch (e:IllegalArgumentException){
            throw e
        }
    }
    fun throwRepeatEmptyException(input:String){
        if(input == ""){
            throw IllegalArgumentException()
        }
    }
}