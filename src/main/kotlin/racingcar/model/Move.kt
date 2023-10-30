package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

object Move {

    private fun createRandomNumber() = Randoms.pickNumberInRange(0, 9)

    fun moveOrStay(car: Car) {
        val number = createRandomNumber()
        if (number >= 4) {
            car.move()
        }
    }
}