package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarView(private var racerCrew:MutableList<String> = mutableListOf()) {
    private val racer = Racer()
    private val requestRacerMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"
    fun signUpRacer(){
        printRequestRacer()
        val unverifiedRacer = Console.readLine()
        val verifiedRacer: MutableList<String> = racer.verifyRacerName(unverifiedRacer)
        this.racerCrew = verifiedRacer
    }

    private fun printRequestRacer(){
        println(requestRacerMessage)
    }
}