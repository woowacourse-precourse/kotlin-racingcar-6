package racingcar

import camp.nextstep.edu.missionutils.Console

class Race {
    private val carNames = CarNames()
    private val carRaceLogic = CarRaceLogic()
    private val winners = Winners()
    private val results = Results()
    private lateinit var carNamesAndResults : Map<String, String>
    private lateinit var inputCarNames : List<String>
    private lateinit var winnersList : List<String>

    fun startRace() {
        println(MessageConstants.INPUT_CAR_NAMES)
        inputCarNames = carNames.getCarNames(Console.readLine())
        carNamesAndResults = carRaceLogic.raceCars(inputCarNames)
        winnersList = winners.findWinners(carNamesAndResults)
        results.printResults(winnersList)
    }
}