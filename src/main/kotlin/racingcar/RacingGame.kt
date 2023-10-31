package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingGame {

    fun randomRace():Int{
        var carNum:Int = pickNumberInRange(0,9)

        return carNum
    }

    fun broadcastRace(numOfCar:Int,carList:MutableList<Players>){

        for(i in 1..numOfCar) {
            var car = carList[i].name
            var score = carList[i].num

            var message:String = "$car : "
            print(message)
            for (i in 1..score) {
                print("-")
            }
            print("\n")
        }
    }
}