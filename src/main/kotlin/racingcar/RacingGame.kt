package racingcar

class RacingGame {

    private val host = Host()
    private val player = Player()
    private val validation = Validation()

    fun getCarNames(): List<Car> {
        host.printRequestEnterCarName()
        val inputCarNames = player.inputCarsName()
        val carNames = inputCarNames.split(",")
        val carList = mutableListOf<Car>()
        for (name in carNames) {
            carList.add(Car(name))
        }
        validation.isValidCarName(inputCarNames, carList)

        return carList
    }
}