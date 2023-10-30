package User

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class User {
    companion object {
        const val MAX_NAME = 5
    }

    fun inputCarName() : List<String>{
        var userNames = Console.readLine()
        var userNameList = userNames.split(',')

        try {
            checkUserName(userNameList)
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
        }
        return userNameList
    }

    fun checkUserName(userNameList: List<String>){
        for( i in 0..userNameList.size-1){
            if(userNameList[i].length > MAX_NAME){
                throw IllegalArgumentException()
            }
        }
    }

    fun inputCycleNumber() : Int{
        var CycleNumber = Console.readLine()
        return CycleNumber.toInt()
    }

    fun printCarInfo(carDistanceList: MutableList<String>, carNameList: List<String>){
        for (i in 0..carNameList.size-1){
            println(carNameList[i] + ":"  + carDistanceList[i])
        }
    }
}