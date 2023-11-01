package racingcar

fun main() {
    // TODO: 프로그램 구현
    val car: Car = Car()
    val carNames = car.createCar()

    car.validateCarNameLength(carNames)
    car.validateDuplicateName(carNames)
    car.validateBlankName(carNames)

    val racing = Racing()
    val moveCount = racing.enterMoveCount()
    racing.validatePositiveInteger(moveCount)
}
