package racingcar

class PrepareGame {

    fun racingCarName(): List<String> {
        val vali = Validation()

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        var userName: String = readLine()
        vali.nameValid(userName)
        var userList: List<String> = userName.split(",")

        return userList
    }

    fun racingNumber(): Int{
        println("시도할 횟수는 몇 회인가요?")
        var raceNum: Int = readLine()!!.toInt()

        return raceNum
    }

    fun makingPlayerList(carNames: List<String>):MutableList<Players> {
        var playerList:MutableList<Players> = mutableListOf<Players>()
        for(element in carNames){
            playerList.add(Players(element,0))
        }
        return playerList
    }

}