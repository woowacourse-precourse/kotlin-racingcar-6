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

        checkUserName(userNameList)
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
            println(carNameList[i] + " : "  + carDistanceList[i])
        }
    }

    fun printCarNameOfMaxDistance(carDistanceList: MutableList<String>, carNameList: List<String>) : String{
        var maxLength = maxSizeOfDistance(carDistanceList)
        var result = makeWinnerString(carDistanceList, carNameList, maxLength)

        if(result.isNotEmpty() && result.endsWith(", ")){
            result = result.removeSuffix(", ")
        }

        return result
    }
    fun maxSizeOfDistance(carDistanceList: MutableList<String>) : Int{
        var temp = 0

        for( i in 0..carDistanceList.size-1){
            if(carDistanceList[i].length > temp){
                temp = carDistanceList[i].length
            }
        }
        return temp
    }

    fun makeWinnerString(carDistanceList: MutableList<String>, carNameList: List<String>, maxLength: Int) : String{
        var result = ""

        for( i in 0..carDistanceList.size-1) {
            if (carDistanceList[i].length == maxLength) {
                result += carNameList[i]
                if (i < carDistanceList.size - 1) {
                    result += ", "
                }
            }
        }
        return result
    }
}