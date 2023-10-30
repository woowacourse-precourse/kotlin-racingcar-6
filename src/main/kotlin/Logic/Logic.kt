package Logic

import User.User
import camp.nextstep.edu.missionutils.Randoms

class Logic {
    val user = User()

    fun makeRandomNumber(){
        var moveNumber = Randoms.pickNumberInRange(0,9)
        println(moveNumber)
    }

    fun makeCarDistanceList(userCount: Int) : List<String>{
        var carDistanceList: MutableList<String> = MutableList(userCount) {""}
        return carDistanceList
    }

    fun moveCar(){

    }
}