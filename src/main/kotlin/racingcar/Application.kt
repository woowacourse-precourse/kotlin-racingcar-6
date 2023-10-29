package racingcar

fun main() {
    val carNames = getCarNames()
    val carNamesAndResults = raceCars(carNames)
    val winners = findWinners(carNamesAndResults)
    printResults(winners)
}
