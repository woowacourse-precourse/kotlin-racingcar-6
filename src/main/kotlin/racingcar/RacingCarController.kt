package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class RacingCarController(private val view: RacingCarView, private val model: RacingCarModel) {
    fun race() {
        signUpRacer(model.racerCrew)
        enterPlayTime(model.racerCrew)
        initializationBeforeJudgeRace()
        for(sequence in 0 until model.racerCrew.playTime) {
            judgeRace(sequence)
            println(model.racerCrew.moveForward)
            printRace()
        }
        /*
        judgeChampion()
        printChampion()
        */
    }

    private fun signUpRacer(racerCrew: Racer){
        view.printRequestRacer()
        val unverifiedRacerName = RacerName(Console.readLine())
        val verifiedRacer: MutableList<String> = unverifiedRacerName.verifyRacerName()
        model.requestUpdateRacerName(verifiedRacer)
        model.requestInitializationMoveForward()
    }

    private fun enterPlayTime(racerCrew: Racer){
        view.printRequestPlayTime()
        val unverifiedPlayTime = RaceTime(Console.readLine().toInt())
        val verifiedPlayTime = unverifiedPlayTime.verifyPlayTime()
        model.requestUpdatePlayTime(verifiedPlayTime)
    }

    private fun initializationBeforeJudgeRace(){
        model.requestInitializationMoveForward()
    }

    private fun judgeRace(sequence: Int){
        val raceMove = RaceMove()
        raceMove.getMoveNumber(model.racerCrew.racerName.size)
        model.requestUpdateMoveForward(raceMove)
    }

    private fun printRace(){
    }
}
