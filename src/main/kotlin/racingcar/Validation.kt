package racingcar

class Validation {

    object GlobalVariables{
        var nameNum: Int = 5
    }

    fun nameValid(name: String): Boolean {
        if (name.length >GlobalVariables.nameNum) return true
        return false
    }

}