package Logic

import camp.nextstep.edu.missionutils.Randoms

class Logic {
    fun makeRandomNumber(){
        var moveNumber = Randoms.pickNumberInRange(0,9)
        println(moveNumber)
    }
}