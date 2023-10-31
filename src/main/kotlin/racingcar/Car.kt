package racingcar

class Car(val name: String, var runCount: Int = 0) {
    fun runOneTime() {
        runCount++
    }
}