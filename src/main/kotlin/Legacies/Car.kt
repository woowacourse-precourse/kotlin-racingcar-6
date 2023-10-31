package Legacies

import camp.nextstep.edu.missionutils.Randoms

class Car(val name : String) {
    private var position = 0L
    fun goOrStop() { position += goOrStopDetermine() }
    fun getPosition() : Long = position

    //outputview로 이동 예정
    fun getCurrentPosition() = "$name : " + lengthToPrint(position)

    //For test Code
    fun addPosition() { position += 1 }

    private fun lengthToPrint(length : Long) : String {
        var position = ""
        for(i in 0 until length) position += "-"
        return position
    }

    private fun goOrStopDetermine() : Long {
        return if(getRandomNumber() in 0..< 4) 0L
        else 1L
    }

    private fun getRandomNumber() : Int = Randoms.pickNumberInRange(0,9)
}