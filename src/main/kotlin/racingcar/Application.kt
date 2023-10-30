package racingcar

fun splitNames(names: String): List<String> {
    return names.split(',')
}

fun inputNames(view: View): List<String> {
    val inputString = view.enterNames()
    val nameList = splitNames(inputString)
    nameList.forEach {
        nameErrorCheck(it)
    }
    redundancyErrorCheck(nameList)
    return nameList
}

fun inputNumberTimes(view: View): Int {
    val times = view.enterNumberTimes()
    numberTimesErrorCheck(times)
    return times.toInt()
}

fun startGame() {
    val view = View()
    val game = Game(view)
    val nameList = inputNames(view)
    val times = inputNumberTimes(view)
    game.playGame(nameList, times)
}

fun main() {
    startGame()
}
