package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

private const val MiN_RANDOM_VALUE = 0
private const val MAX_RANDOM_VALUE = 9
private const val MIN_MOVE_VALUE = 4
object Move {

    private fun createRandomNumber() = Randoms.pickNumberInRange(MiN_RANDOM_VALUE, MAX_RANDOM_VALUE)

    fun moveOrStay(car: Car) {
        val number = createRandomNumber()
        if (number >= MIN_MOVE_VALUE) {
            car.move()
        }
    }
}

