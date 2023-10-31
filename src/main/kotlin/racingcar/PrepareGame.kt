package racingcar

class PrepareGame {

    fun racingCarName(): List<String> {
        var userName: String = readLine()
        var userList: List<String> = userName.split(",")

        return userList
    }

    fun racingNumber(): Int{
        var raceNum: Int = readLine().toInt()

        return raceNum
    }

    fun makingPlayerList(carNames: List<String>):MutableList<Players> {
        var playerList:MutableList<Players> = mutableListOf<Players>()

        for(i in 1..carNames.size){
            playerList[i]=Players(carNames[i],0)
        }
        return playerList
    }

}