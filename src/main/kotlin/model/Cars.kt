package model

class Cars {
    private var _carNames = mutableListOf<Car>()
    val carNames: List<Car>
        get() = _carNames

    fun addAllList(carNames: List<String>) = _carNames.addAll(carNames.map { Car(it) })

    fun getMaxDistance(): Int = _carNames.maxOf { it.distance }
}