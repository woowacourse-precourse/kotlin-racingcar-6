package racingcar

class RoundResultPresenter(private val cars: List<Car>) {
    fun showRoundResult() {
        printCarStatus()
    }

    private fun printCarStatus() =
        cars.forEach { println("${it.name} : ${"-".repeat(it.scoreSum)}") }.also { println() }

}