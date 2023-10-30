package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Cars(name:String) {
    val carName= name
    var carPosition = 0

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun chooseActionFromRandomNumber() {
        val randomNumber = generateRandomNumber()
        if (randomNumber >= 4){
            carPosition++
        }
    }

    fun changeRepeatPosition() {
        repeat(carPosition) { print("-") }
    }

}