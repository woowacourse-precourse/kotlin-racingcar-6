package racingcar

fun splitNames(names: String): List<String> {
    return names.split(',')
}


fun validateNameList(nameList: List<String>) {
    nameList.forEach { nameErrorCheck(it) }
    redundancyErrorCheck(nameList)
}

fun inputNames(view: View): List<String> {
    val inputString = view.enterNames()
    val nameList = splitNames(inputString)
    validateNameList(nameList)
    return nameList
}

fun getInputTimes(view: View): Int {
    val times = view.enterNumberTimes()
    numberTimesErrorCheck(times)
    return times.toInt()
}

fun inputNumberTimes(view: View): Int {
    return getInputTimes(view)
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
