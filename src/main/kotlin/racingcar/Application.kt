package racingcar

fun main() {

    val machine = InputMachine()

//    val carsList : List<String> = machine.makeCars()
//
//    val carsClass : MutableList<Car> = mutableListOf()
//
//    // car 선언
//    for (car in carsList) {
//        carsClass.add(Car(car))
//    }
//
//    machine.checkCarNameUnder5(carsClass)

    val tryCount = machine.tryMove()

}
