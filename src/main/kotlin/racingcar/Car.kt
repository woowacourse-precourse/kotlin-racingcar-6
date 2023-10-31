package racingcar

class Car(named: String) {
    var name: String = named
    var position: Int = 0

    fun goPos(){
        position++
    }

}