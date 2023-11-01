package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(var name:String) {
    var position = 0

    fun move() {
        if (getRandomNumber()>=4){
            position += 1
        }

    }

    fun getRandomNumber() = Randoms.pickNumberInRange(0,9)

    fun getOutput():String = "$name : ${"-".repeat(position)}\n"

    override fun toString() = "$name"
}