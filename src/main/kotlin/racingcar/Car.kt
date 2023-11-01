package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Car (private val name: String){
    private var pos: Int = 0
    init {
        if (name.length > 5) {
            throw IllegalArgumentException("Name '$name' is too long")
        }
        if (name.isEmpty()) {
            throw IllegalArgumentException("Empty name")
        }
    }
    private fun getRand(): Int {
        return Randoms.pickNumberInRange(0,9)
    }
    fun move() {
        if (getRand() > 3) {
            pos += 1
        }
    }

    fun getPos(): Int {
        return pos
    }

    fun getName(): String {
        return name
    }
    fun printCar() {
        println("$name : " + "-".repeat(pos))
    }

}