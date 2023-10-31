package racingcar

class Car(carname: String) {
    var position = 0
    var name = carname
    fun plus(){
        position++
    }
}