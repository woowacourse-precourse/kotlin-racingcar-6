package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarController(private val view: RacingCarView, private val model: RacingCarModel) {
    fun race() {
        signUpRacer() //자동차 경주 입력 요청 및 처리
        enterPlayTime() //이동 시도 횟수 입력 요청 및 처리
        initializationMoveDistance() //이동 거리 리스트 초기화
        requestPrintResultText() //실행 결과 텍스트 사전 출력
        for(sequence in FIRST_SEQUENCE until model.racerCrew.playTime) { //
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

    private fun initializationMoveDistance() {
        model.requestInitializationMoveDistance()
    }

    private fun requestPrintResultText() {
        view.printResultText()
    }

    private fun judgeRace() {
        val raceMove = RaceMove()
        raceMove.getMoveNumber(model.racerCrew.racerName.size)
        model.requestUpdateMoveDistance(raceMove)
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
