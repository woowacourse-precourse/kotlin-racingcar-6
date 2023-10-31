package racingcar

class Validation {

    fun nameValid(name:String){
        if(name.length>5) throw IllegalArgumentException()
        requireNotNull(name)
    }


}