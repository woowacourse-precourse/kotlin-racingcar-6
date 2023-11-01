package racingcar

class Car(private val objectName: String) { // 객체명이 printLocation()에서 사용되므로 받아 옴.
    var location: Int = 0

    fun moveCar() {
        if ( goOrStop() ) {
            location++
        }
    }

    fun printLocation() {
        val currentLocation = "-".repeat(location)
        println("$objectName : $currentLocation")
    }

}