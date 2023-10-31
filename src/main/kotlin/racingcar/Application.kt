fun main() {
    val carNames = getCarNames()
    val tryCount = getTryCount()
    val cars = createCars(carNames)

    race(cars, tryCount)
}

fun getCarNames(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readLine()
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자를 입력하세요.")
}

fun createCars(carNames: String?): List<Car> {
    return carNames?.split(",")?.map { Car(it.trim()) }
        ?: throw IllegalArgumentException("올바른 자동차 이름을 입력하세요.")
}
