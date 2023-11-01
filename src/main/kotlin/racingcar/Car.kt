package racingcar

class Car(val name: String) {

    private var position = INITIAL_CAR_POSITION

    fun findForwardCondition(randomNumber: Int): Boolean {
        return randomNumber >= MIN_FORWARD_POSITION
    }

    fun move(randomNumber: Int): Int {
        if (findForwardCondition(randomNumber)) {
            position++
        }
        print("$name : ${ADVANCE.repeat(position)}")

        return position
    }

}