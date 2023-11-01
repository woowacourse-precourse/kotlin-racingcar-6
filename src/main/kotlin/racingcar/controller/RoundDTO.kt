package racingcar.controller

class RoundDTO(val count:String) {

    fun convertRoundCount() = count.toInt()
}