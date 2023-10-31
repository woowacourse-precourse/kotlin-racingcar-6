package racingcar

class Car(name: String) {
    var position = 0
    var name = name

    fun step(){
        position++
    }
}