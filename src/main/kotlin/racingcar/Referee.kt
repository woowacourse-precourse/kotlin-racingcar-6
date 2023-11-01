package racingcar

class Referee(
    namesOfParticipants: List<String>,
    private val roundNum: Int,
    val doSomethingWithCarsAfterRound: (List<Car>) -> Unit
) {
    private val cars: List<Car> = namesOfParticipants.map{Car(it)}

    private fun runRound() {
        cars.forEach{it.goForwardOrStop()}
        doSomethingWithCarsAfterRound(cars)
    }
    private fun runAllRounds() = repeat(roundNum){ runRound() }
    fun getWinners(): List<Car> {
        runAllRounds()
        val winnerPosition = cars.max().position
        return cars.filter{it.position == winnerPosition}
    }
}