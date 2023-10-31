package racingcar

class Car(name: String) {
    private val name: String
    private var distance: String

    init {
        require(name.length in 1 until 6) { "이름은 1자 이상, 5자 이하만 가능합니다." }
        this.name = name
        this.distance = ""
    }

    fun drive() {
        this.distance = distance.plus('-')
    }

    fun getName(): String = name

    fun getDistance(): String = distance

    fun getDistanceLength(): Int = distance.length
}