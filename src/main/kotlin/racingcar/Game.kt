package racingcar

class Game {

    fun play() {
        val input = Input()
        val carListName = input.inputCarName()
        val carMoveTime = input.inputMoveTimes()

        val race = Race()
        race.startRace(carListName, carMoveTime)
    }
}