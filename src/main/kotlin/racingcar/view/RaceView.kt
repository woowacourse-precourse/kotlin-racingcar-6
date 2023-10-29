package racingcar.view

class RaceView {
    fun printCarProgress(carStatus: MutableMap<String, String>) {
        for (car in carStatus) {
            println(car.key + " : " + car.value)
        }
        println("")
    }
}
