package racingcar.dto

class CarDTO (private val carName: String, private val position: Int){

    fun getCarName(): String {
        return carName
    }

    fun getPositionNumber(): Int {
        return position
    }
}