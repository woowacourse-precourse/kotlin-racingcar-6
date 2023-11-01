package racingcar

data class Car(private val name: String, private var position: Int = 0) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }
}