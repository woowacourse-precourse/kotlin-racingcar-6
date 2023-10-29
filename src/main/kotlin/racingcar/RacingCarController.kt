package racingcar

import camp.nextstep.edu.missionutils.Console


class RacingCarController(private val view: RacingCarView, private val model: RacingCarModel) {
    fun race() {
        signUpRacer(model.racerCrew)
        enterPlayTime(model.racerCrew)
        /*
        for(sequence in 0 until model.racerCrew.playTime) {
            model.judgeRace(sequence)
            view.printRace()
        }
        judgeChampion()
        printChampion()
        */
    }

    private fun signUpRacer(racerCrew: Racer){
        view.printRequestRacer()
        val unverifiedRacerName = RacerName(Console.readLine())
        val verifiedRacer: MutableList<String> = unverifiedRacerName.verifyRacerName()
        model.requestUpdateRacerName(verifiedRacer)
    }

    private fun enterPlayTime(racerCrew: Racer){
        view.printRequestPlayTime()
        val unverifiedPlayTime = RaceTime(Console.readLine().toInt())
        val verifiedPlayTime = unverifiedPlayTime.verifyPlayTime()
        model.requestUpdatePlayTime(verifiedPlayTime)
    }


}
