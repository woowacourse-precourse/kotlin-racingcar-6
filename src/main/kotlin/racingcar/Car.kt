package racingcar

class Car(private val carName: String) {
    val name = carName
    var raceProgress: String = ""

    fun move() {
        raceProgress += "-"
    }

    fun isWinner(max: Int): Boolean {
        return raceProgress.length == max
    }
}