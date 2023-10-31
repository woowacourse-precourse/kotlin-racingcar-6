package racingcar

data class Car(val name: String) {
    var distance: Int = 0
    fun checkMove() {
        if (Random().generatorRandomNum() >= 4) {
            distance++
        }
    }

    fun display(): String {
        return "$name : ${GO.repeat(distance)}"

    }

    companion object {
        const val STOP = ""
        const val GO = "-"
    }
}
