package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {
    private var name:String
    private var distance = 0

    constructor(name:String){
        this.name = name
    }

    fun getName():String{
        return name
    }

    fun moveForward() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            distance += 1
        }
    }

    fun showDistanceWithName() {
        print("${name} : ")
        for (i in 1..distance){
            print("-")
        }
        println()
    }
}