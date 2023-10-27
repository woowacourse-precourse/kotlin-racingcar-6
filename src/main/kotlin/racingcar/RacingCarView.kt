package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarView(private var racerCrew:MutableList<String> = mutableListOf(), private var playTime:Int=0) {
    //private val racer = Racer()
    //private val movechance = RaceTime()
    private val requestRacerMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"
    private val requestPlayTimeMessage = "시도할 횟수는 몇 회인가요?"
    fun signUpRacer() { //자동차 이름 입력 요청 및 처리
        printRequestRacer()
        val unverifiedRacer = Racer(Console.readLine())
        val verifiedRacer: MutableList<String> = unverifiedRacer.verifyRacerName()
        this.racerCrew = verifiedRacer
    }

    fun enterPlayTime(){ //이동 시도 횟수 입력 요청 및 처리
        printrequestPlayTime()
        val unverifiedPlayTime = RaceTime(Console.readLine().toInt())
        val verifiedPlayTime = unverifiedPlayTime.verifyPlayTime()
        this.playTime = verifiedPlayTime
    }

    private fun printRequestRacer(){
        println(requestRacerMessage)
    }

    private fun printrequestPlayTime(){
        println(requestPlayTimeMessage)
    }
}