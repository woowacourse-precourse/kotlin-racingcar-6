package racingcar

class Car(name : String) {
    private val name : String = name
    private var loc = 0

    fun move(){
        loc++
    }
}