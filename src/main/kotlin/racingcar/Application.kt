package racingcar

fun main() {

    val machine = InputMachine()
    val cars : List<String> = machine.makeCars()
    machine.checkCarNameUnder5(cars)
}
