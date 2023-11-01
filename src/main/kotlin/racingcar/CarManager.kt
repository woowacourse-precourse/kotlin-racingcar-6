package racingcar
import camp.nextstep.edu.missionutils.Randoms

const val MOVE_CONDITION = 4
class Car(name: String) {
    private val name: String = name
    private var randomNumber:Int = 0
    private var location = 0

    fun compareRandom() : Boolean = randomNumber >= MOVE_CONDITION
    fun getName() = name
    fun getLocation() = location
    fun moveForward() {
        location++
    }

    fun setNewRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9)
    }
    fun printLocation() {
        print("$name : ")
        for (x in 1..location) {
            print("-")
        }
        println()
    }
}