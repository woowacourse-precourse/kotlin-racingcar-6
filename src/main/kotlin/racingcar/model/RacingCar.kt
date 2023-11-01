package racingcar.model

class RacingCar(private val carName: String, private var forward: Int = 0) {
    fun moveForward() {
        forward++
    }

    fun getCarName(): String {
        return carName
    }

    fun getForward(): Int {
        return forward
    }

}