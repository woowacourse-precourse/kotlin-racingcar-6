package racingcar.model

class Car(carName: String) {
    private val carName: String
    private val movedDistance: Int
    init {
        this.carName = carName
        this.movedDistance = 0
    }
}