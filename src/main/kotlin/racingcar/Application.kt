package racingcar
class RacingCar(val name: String) {
    var position = 0
}

fun main() {
    try {


    } catch (e: IllegalArgumentException) {
        println("에러: ${e.message}")
    }
}
