package racingcar

import racingcar.Model.Car
import racingcar.View.InputView
import racingcar.View.OutputView

class Race() {
    private var round = 0
    private lateinit var cars : List<Car>
    fun run(){
        cars = getCarList(InputView.getNameList(InputView.getNameInput()))
        round = InputView.getRoundNumber()

        OutputView.printExecutionResultMention()
        allRounds()
    }

    fun testRun() : String{
        cars = listOf<Car>(Car("pobi"), Car("woni"))
        round = 1

        return "최종 우승자 : ${getWinnerList().joinToString(", ")}"
    }

    private fun testOneRound() {
        cars.forEach { it.addPosition() }
        OutputView.printExecutionResult(cars)
    }

    private fun testAllRounds(){
        repeat(round) { testOneRound() }
        OutputView.printWinners(getWinnerList())
    }

    private fun getCarList(list : List<String>) : List<Car> {
        val carList = mutableListOf<Car>()
        list.forEach {
            carList.add(Car(it))
        }
        return carList
    }

    private fun allRounds() {
        repeat(round) { oneRound() }
        OutputView.printWinners(getWinnerList())
    }

    private fun oneRound() {
        cars.forEach { it.goOrStop() }
        OutputView.printExecutionResult(cars)
    }

    private fun getWinnerList() : List<String> {
        val nameList = mutableListOf<String>()
        val farthest = getFarthestPosition()

        cars.forEach {
            if(it.getPosition() == farthest) nameList.add(it.name)
        }
        return nameList
    }

    private fun getFarthestPosition() : Int {
        var farthest = 0
        cars.forEach {
            if(it.getPosition() > farthest) farthest = it.getPosition()
            //farthest = kotlin.math.max(farthest, it.getPosition())
        }
        return farthest
    }
}