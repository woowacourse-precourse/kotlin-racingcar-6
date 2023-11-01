package racingcar

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val user = Input()
    val carName = user.inputCarName()

    println("시도할 횟수는 몇 회인가요?")
    val count = user.inputGameNumber()

    println("실행 결과")
    var car: MutableList<Car> = mutableListOf()
    setCar(carName, car)

    val move = Move(car)
    repeat(count) {
        val carMove = move.moveCar()
    }
    val result = move.compareMoveNumber()

}

fun setCar(carName: MutableList<String>, car: MutableList<Car>) {
    for (i in carName) {
        car.add(Car(name = i.toString()))
    }
}
