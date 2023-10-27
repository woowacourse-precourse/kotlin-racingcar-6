package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name : String) {
    private var position = 0
    fun oneRound() { position += goOrStop() }
    fun getPosition() : Int = position

    //outputview로 이동 예정
    fun printCurrentPosition() = println("$name : " + lengthToPrint(position))

    fun lengthToPrint(length : Int) : String {
        var position = ""
        for(i in 0 until length) position += "-"
        return position
    }


    fun goOrStop() : Int {
        return if(getRandomNumber() in 0..< 4) 0
        else 1
    }

    fun getRandomNumber() : Int = Randoms.pickNumberInRange(0,9)
}