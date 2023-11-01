package racingcar

class Car {
    var location: Int = 0

    fun moveCar() {
        if ( goOrStop() ) {
            location++
        }
    }

}