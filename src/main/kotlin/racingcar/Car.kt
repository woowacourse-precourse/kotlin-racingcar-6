package racingcar

class Car (private val name: String){
    private var pos: Int = 0

    fun move() {
        pos += 1
    }

    fun getPos(): Int {
        return pos
    }

    fun printCar() {
        println("$name : " + "-".repeat(pos))
    }
}