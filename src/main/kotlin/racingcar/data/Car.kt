package racingcar.data

data class Car(val name: String) {
    var distance: Int = 0
        private set

    fun addDistance() {
        this.distance += 1
    }

    override fun toString(): String {
        return name
    }
}