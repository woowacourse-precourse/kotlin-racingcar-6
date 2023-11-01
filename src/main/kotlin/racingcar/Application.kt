package racingcar

fun main() {

    val machine = InputMachine()
    val racing = Racing()

    val carsList : List<String> = machine.makeCars()

    val carsClass : MutableList<Car> = mutableListOf()

    // car 선언
    for (car in carsList) {
        carsClass.add(Car(car))
    }

    racing.forwardOver4(carsClass)
}
