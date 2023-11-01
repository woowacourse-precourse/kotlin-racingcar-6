package racingcar.command

import racingcar.model.Car

class DoRaceCommand(private val car: Car): Command {
    override fun execute() {
        car.doRace()
    }
}