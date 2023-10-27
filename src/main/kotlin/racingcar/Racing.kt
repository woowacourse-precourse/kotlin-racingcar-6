package racingcar

class Racing() {
    private var round = 0
    private lateinit var cars : List<Car>
    fun run(){
        cars = getCarList(InputView.getNameList())
        round = InputView.getRoundNumber()

        OutputView.printExecutionResultMention()
        allRounds()
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

    fun getWinnerList() : List<String> {
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