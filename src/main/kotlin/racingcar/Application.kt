package racingcar

class Car(val name: String) {
    var position = 0
        private set
    init {
        require(name.length <= 5){ "Car name length exceeds 5 letters" }
    }
}

fun main() {
    // TODO: 프로그램 구현
}
