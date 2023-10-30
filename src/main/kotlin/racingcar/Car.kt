package racingcar

class Car(
    private val name: String,
    private val howAdvanced: Int = 0
) {
    fun getCarName() = this.name

}