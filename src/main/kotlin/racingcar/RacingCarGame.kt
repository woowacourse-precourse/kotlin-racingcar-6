package racingcar

class RacingCarGame {
    private val racingCarGenerator = RacingCarGenerator()

    fun run() {
        racingCarGenerator.createRacingCars()
        print(racingCarGenerator.getRacingCars())
    }
}