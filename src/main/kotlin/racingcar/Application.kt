package racingcar

fun Run.execute(): Run {
    inputData()
    play()
    printWinners()
    return this
}

fun main() {
    Run().execute()
}
