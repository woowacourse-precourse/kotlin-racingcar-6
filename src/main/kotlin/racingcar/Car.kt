package racingcar

import camp.nextstep.edu.missionutils.Randoms


class Car(val name: String) {
    init {
        if (name.length > 5) throw IllegalArgumentException("5자 이상 이름 필요")
    }

    var location: Int = 0
    fun randMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) location++
    }
}

fun List<Car>.toStatusString(): String {
    val progressCharacter = "-"
    return this.map { "${it.name} : ${progressCharacter.repeat(it.location)}" }
        .joinToString(separator = "\n", postfix = "\n")
}

fun List<Car>.race(loopCount: Int) {
    for (i in 1..loopCount) {
        this.forEach { it.randMove() }
        println(this.toStatusString())
    }
}

fun List<Car>.winner(): String {
    val maxLocation = this.maxOf { it.location }
    val winners = this.filter { it.location == maxLocation }
    return winners.map { it.name }.joinToString(", ")
}
