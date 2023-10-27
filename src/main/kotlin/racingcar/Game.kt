package racingcar

class Game {
    private val input = View()
    private val cars = mutableListOf<Car>()

    fun startGame() {
        makeCars()
        val times = input.enterNumberTimes()
        numberTimesErrorCheck(times)
        for (i in 1..times.toInt()) {
            moveCars()
            input.printPosition(cars)
        }
        input.printWinner(makeWinnerList(checkLeadPosition()))
    }

    private fun moveCars() {
        for (i in cars) {
            val num = i.generateRandomNumber()
            i.updatePosition(i.judgeNumber(num))
        }
    }

    private fun splitNames(names: String): List<String> {
        return names.split(',')
    }

    private fun makeCars() {
        val names = splitNames(input.enterNames())
        redundancyErrorCheck(names)
        names.forEach {
            cars.add(Car(it))
        }
    }

    private fun checkLeadPosition(): Int {
        var leadPosition = 0
        for (i in cars) {
            if (leadPosition < i.getPositionNumber()) {
                leadPosition = i.getPositionNumber()
            }
        }
        return leadPosition
    }

    private fun makeWinnerList(leadPosition: Int): List<String> {
        val winnerList = mutableListOf<String>()
        for (i in cars) {
            if (leadPosition == i.getPositionNumber()) {
                winnerList.add(i.getName())
            }
        }
        return winnerList
    }

}