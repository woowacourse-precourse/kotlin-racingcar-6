package domain

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {

    private var position: Int = 0

    fun move() {
        val canMove = Randoms.pickNumberInRange(0, 9)
        if (canMove >= Condition.STANDARD.value) {
            position++
        }
    }

    fun getCurrentPosition(): Int {
        return this.position
    }

    fun getName(): String {
        return this.name
    }

    enum class Condition(val value: Int) {
        STANDARD(4)
    }
}