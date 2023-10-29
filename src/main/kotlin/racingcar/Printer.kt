package racingcar

class Printer {

    fun printInputRacingCarNamesMessage() {
        println(Messages.INPUT_RACING_CAR_NAMES)
    }

    fun printInputTryTimeMessage() {
        println(Messages.INPUT_TRY_TIME)
    }

    fun printRacingCarStates(racingCars: List<RacingCar>) {
        println(Messages.TRY_RESULT)
        racingCars.forEach { car ->
            car.printState()
        }
        println()
    }

    fun printWinners(names: List<String>) {
        print(Messages.WINNER)
        names.forEachIndexed { index, name ->
            if (index != 0) {
                print(", ")
            }
            print(name)
        }
    }

    private fun RacingCar.printState() {
        var bar = ""
        repeat(movingCount) {
            bar += "-"
        }
        println("$name : $bar")
    }
}