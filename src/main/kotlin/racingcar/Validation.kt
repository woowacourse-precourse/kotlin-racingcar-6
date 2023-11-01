package racingcar

class Validation {

    object GlobalVariables{
        var nameNum: Int = 5
    }

    fun nameValid(userList: List<String>) {

        for(i in userList){
            if (i.length >GlobalVariables.nameNum) throw IllegalArgumentException()
        }
    }



}