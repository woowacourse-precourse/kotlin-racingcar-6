package racingcar
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carNames = getCarNames(readLine())
    val carNamesAndResults = raceCars(carNames)
    val winners = findWinners(carNamesAndResults)
    printResults(winners)
}
