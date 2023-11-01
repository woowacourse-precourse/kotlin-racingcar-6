package racingcar

class Validation {

    object GlobalVariables{
        var nameNum: Int = 5
    }

    fun nameValid(name: String) {
        if (name.length >GlobalVariables.nameNum) throw IllegalArgumentException()
    }
    
}