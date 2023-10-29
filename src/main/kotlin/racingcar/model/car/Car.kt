package racingcar.model.car

class Car(
    val name: CarName,
    private val engine: Engine
) {
    var distance = 0
        private set

    fun tryGoForward() {
        distance += engine.work()
    }
}