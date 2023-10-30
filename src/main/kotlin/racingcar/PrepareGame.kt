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

}