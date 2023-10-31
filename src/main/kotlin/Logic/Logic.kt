package Logic

import User.User
import camp.nextstep.edu.missionutils.Randoms

class Logic {
    val user = User()

    fun makeCarDistanceList(userCount: Int) : MutableList<String>{
        var carDistanceList: MutableList<String> = MutableList(userCount) {""}
        return carDistanceList
    }

    fun moveCar(carDistanceList: MutableList<String>) : MutableList<String>{
        for(i in 0..carDistanceList.size-1) {
            var moveNumber = Randoms.pickNumberInRange(0,9)
            if(moveNumber >= 4){
                carDistanceList[i] += "-"
            }else{
                carDistanceList += ""
            }
        }
        return carDistanceList
    }
}