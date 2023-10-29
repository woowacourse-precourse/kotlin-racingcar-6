package racingcar

fun moveCar(carNames: List<String>, tryNum: Int): Map<String, Int> {
    val carPositions = initializeCarPositions(carNames)

    repeat(tryNum) {
        updateCarPositions(carNames, carPositions)
        displayCarPositions(carNames, carPositions)
        println()
    }
    return carPositions
}

fun initializeCarPositions(carNames: List<String>): MutableMap<String, Int> {
    val carPositions = mutableMapOf<String, Int>()
    carNames.forEach { car ->
        carPositions[car] = 0
    }
    return carPositions
}

fun updateCarPositions(carNames: List<String>, carPositions: MutableMap<String, Int>) {
    carNames.forEach { car ->
        if (randomValue() >= 4) {
            carPositions[car] = carPositions[car]!! + 1
        }
    }
}

fun displayCarPositions(carNames: List<String>, carPositions: Map<String, Int>) {
    carNames.forEach { car ->
        println("$car : ${"-".repeat(carPositions[car]!!)}")
    }
}