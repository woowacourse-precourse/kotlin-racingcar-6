package racingcar.model

class Car(
    name: String,
    private var position: Int = 0
) {
    val name: CarName = CarName(name)
}