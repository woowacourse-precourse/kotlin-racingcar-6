package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarController(private val view: RacingCarView, private val model: RacingCarModel) {
    fun race() {
        signUpRacer()
        enterPlayTime()
        initializationMoveForward()
        requestPrintResultText()
        for(sequence in 0 until model.racerCrew.playTime) {
            judgeRace()
            printRace()
        }
        judgeChampion()
        printChampion()
    }

    private fun signUpRacer() {
        view.printRequestRacer()
        val unverifiedRacerName = RacerName(Console.readLine())
        val verifiedRacer: MutableList<String> = unverifiedRacerName.verifyRacerName()
        model.requestUpdateRacerName(verifiedRacer)
    }

    private fun enterPlayTime() {
        view.printRequestPlayTime()
        val unverifiedPlayTime = RaceTime(Console.readLine().toInt())
        val verifiedPlayTime = unverifiedPlayTime.verifyPlayTime()
        model.requestUpdatePlayTime(verifiedPlayTime)
    }

    private fun initializationMoveForward() {
        model.requestInitializationMoveForward()
    }

    private fun requestPrintResultText() {
        view.printResultText()
    }

    private fun judgeRace() {
        val raceMove = RaceMove()
        raceMove.getMoveNumber(model.racerCrew.racerName.size)
        model.requestUpdateMoveForward(raceMove)
    }

    private fun printRace() {
        view.printRaceOnView(model.racerCrew)
    }

    private fun judgeChampion() {
        model.requestJudgeChampion()
    }

    private fun printChampion() {
        view.printChampionOnView(model.raceChampion)
    }
}
