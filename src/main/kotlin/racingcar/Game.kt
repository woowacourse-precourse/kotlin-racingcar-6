package racingcar

class Game {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }
}

class Car(val name: String) {
    var location: Int = 0
    fun randMove(): Unit = TODO()
}