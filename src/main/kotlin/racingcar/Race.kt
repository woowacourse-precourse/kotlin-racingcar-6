package racingcar

import camp.nextstep.edu.missionutils.Console

class Race {
    private val carNames = CarNames()
    private val carRaceLogic = CarRaceLogic()
    private val findWinners = FindWinners()
    private val printWinners = PrintWinners()
    private lateinit var carNamesAndResults : Map<String, String>
    private lateinit var inputCarNames : List<String>
    private lateinit var winnersList : List<String>

    fun startRace() {
        println(MessageConstants.INPUT_CAR_NAMES)
        inputCarNames = carNames.getCarNames(Console.readLine())
        carNamesAndResults = carRaceLogic.raceCars(inputCarNames)
        winnersList = findWinners.findWinners(carNamesAndResults)
        printWinners.printResults(winnersList)
    }
}