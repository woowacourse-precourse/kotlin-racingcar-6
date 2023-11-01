package racingcar

class Car(val name: String) {

    private var position = 0

    private fun findForwardCondition(randomNumber: Int): Boolean {
        return randomNumber > 3
    }

    fun move(randomNumber: Int): Int {
        if (findForwardCondition(randomNumber)) {
            position++
        }
        print("$name : ${"-".repeat(position)}")
        return position
    }

}