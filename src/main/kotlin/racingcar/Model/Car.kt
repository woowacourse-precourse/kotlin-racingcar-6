package racingcar.Model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name : String) {
    private var position = 0
    fun goOrStop() { position += goOrStopDetermine() }
    fun getPosition() : Int = position

    //outputview로 이동 예정
    fun getCurrentPosition() = "$name : " + lengthToPrint(position)

    //For test Code
    fun addPosition() { position += 1 }

    private fun lengthToPrint(length : Int) : String {
        var position = ""
        for(i in 0 until length) position += "-"
        return position
    }


    private fun goOrStopDetermine() : Int {
        return if(getRandomNumber() in 0..< 4) 0
        else 1
    }

    private fun getRandomNumber() : Int = Randoms.pickNumberInRange(0,9)
}