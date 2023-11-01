package racingcar

fun winner(carPositions: Map<String, Int>) {
    val maxPosition = carPositions.values.maxOrNull()
    val winners = carPositions
        .filter { it.value == maxPosition }
        .keys
        .joinToString(", ")

    println("최종 우승자 : $winners")
}
