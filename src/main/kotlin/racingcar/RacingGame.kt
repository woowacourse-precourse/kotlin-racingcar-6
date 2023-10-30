package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingGame {

    fun randomRace():Int{
        var carNum:Int = pickNumberInRange(0,9)

        return carNum
    }

    fun broadcastRace(x:Players){
        val message = "x.name : "
        val a = x.num
        print(message)
        for(i in 1..a) {
            print("-")
        }
        print("\n")
    }
}