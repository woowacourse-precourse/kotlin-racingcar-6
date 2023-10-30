package Logic

import User.User
import camp.nextstep.edu.missionutils.Randoms

class Logic {
    val user = User()

    fun makeRandomNumber() : Int{
        var moveNumber = Randoms.pickNumberInRange(0,9)
        return moveNumber
    }

    fun makeCarDistanceList(userCount: Int) : MutableList<String>{
        var carDistanceList: MutableList<String> = MutableList(userCount) {""}
        return carDistanceList
    }

    fun moveCar(carDistanceList: MutableList<String>) {
        for(i in 0..carDistanceList.size-1) {
            if(makeRandomNumber() > 4){
                carDistanceList[i] += "-"
            }
        }
    }

}