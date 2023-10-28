package User

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class User {
    companion object {
        const val MAX_NAME = 5
    }
    fun inputCarName(){
        var userNames = Console.readLine()
        var userNameList = userNames.split(',')

        try {
            checkUserName(userNameList)
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
        }
    }

    fun checkUserName(userNameList: List<String>){
        for( i in 0..userNameList.size-1){
            if(userNameList[i].length > MAX_NAME){
                throw IllegalArgumentException()
            }
        }
    }


}