package racingcar

fun moveCar(carNames : List<String>, tryNum : Int) : Map<String, Int> { // 전진 출력
    val carPositions = mutableMapOf<String, Int>()

    // 처음 위치 설정
    carNames.forEach { car ->
        carPositions[car] = 0
    }

    repeat(tryNum) {
        carNames.forEach { car ->
            if (randomValue() >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
            println("$car : ${"-".repeat(carPositions[car]!!)}")
        }
        println()
    }
    return carPositions
}