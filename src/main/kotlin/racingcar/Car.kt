package racingcar

class Car(name : String) {
    private val name = name
    private var loc = 0

    fun move(){
        loc++
    }
}