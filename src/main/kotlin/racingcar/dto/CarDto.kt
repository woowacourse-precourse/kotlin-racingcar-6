package racingcar.dto

class CarDto (private val carName: String, private val position: Int) {

    fun getCarName(): String {
        return carName
    }

    fun getPositionNumber(): Int {
        return position
    }
}