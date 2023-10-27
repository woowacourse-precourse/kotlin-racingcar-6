package racingcar

class RacingCarController(private val view: RacingCarView, private val model: RacingCarModel) {
    fun race() {
        view.signUpRacer()
        /*enterPlayTime()
        for() {
            judgeRace()
            printRace()
        }
        judgeChampion()
        printChampion()*/
    }
}