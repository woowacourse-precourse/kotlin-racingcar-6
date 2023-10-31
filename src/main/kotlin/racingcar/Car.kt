package racingcar

class Car(carname: String) {
    var name = carname
    var position = 0

    fun stepPosition(){
        position++
    }
}