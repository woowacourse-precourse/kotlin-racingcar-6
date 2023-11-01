package racingcar

class Car(var name: String) {
    var count = 0
    fun move(number: Int) {
        if (number >= 4) {
            count += 1
        }
    }

    fun print() {
        println("$name : ${"-".repeat(count)}")
    }


    override fun toString(): String = "$name"
}