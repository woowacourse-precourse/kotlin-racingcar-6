package Legacies



class Race() {
    private var round = 0L
    private lateinit var cars : List<Car>
    fun run(){
        cars = getCarList(InputView.inputCarName())
        round = InputView.getRoundNumber()

        OutputView.printExecutionResultMention()
        allRounds()
        InputView.consoleClose()
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
        for (i in 0 until round)  testOneRound()
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
        for(i in 0 until round)  oneRound()
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

    private fun getFarthestPosition() : Long {
        var farthest = 0L
        cars.forEach {
            if(it.getPosition() > farthest) farthest = it.getPosition()
            //farthest = kotlin.math.max(farthest, it.getPosition())
        }
        return farthest
    }
}