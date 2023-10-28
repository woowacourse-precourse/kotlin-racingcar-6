package racingcar

class CarModel(private val name: String) {
    private var distance: Int = 0
    private var distanceString: String = ""

    fun printPresentDistance() = println("$name : $distanceString")
    fun moveForward() {
        distanceString += "-"
        distance++
    }

    fun getDistance(): Int {
        return distance
    }
    fun getName(): String {
        return name
    }
}