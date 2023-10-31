package racingcar

fun main() {
    // TODO: 프로그램 구현
    val car: Car = Car()
    val carNames = car.createCar()

    car.validateCarNameLength(carNames)
}
