package racingcar

class Car(private val name: String) {
    var distance = ""
    var moveCount = 0
    val carName = name
    fun move(num: Int) {
        if (num > 3) {
            moveCount++
            distance += "-"
            println("$carName : $distance")
        } else
            println("$carName : $distance")
    }
}