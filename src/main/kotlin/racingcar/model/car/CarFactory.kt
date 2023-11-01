package racingcar.model.car

fun interface CarFactory {
    fun create(name: CarName): Car
}