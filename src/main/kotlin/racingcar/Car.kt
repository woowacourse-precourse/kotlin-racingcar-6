package racingcar

class Car(name: String) {
    val name: String
    private var _distance: String
    val distance: String
        get() = this._distance
    val distanceLength: Int
        get() = distance.length

    init {
        require(name.length in 1 until 6) { "이름은 1자 이상, 5자 이하만 가능합니다." }
        this.name = name
        this._distance = ""
    }

    fun drive() {
        this._distance = _distance.plus('-')
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false
        if (name != other.name) return false
        if (distance != other.distance) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + distance.hashCode()
        return result
    }
}