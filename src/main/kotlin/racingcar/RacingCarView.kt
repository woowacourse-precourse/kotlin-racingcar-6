package racingcar

class RacingCarView() {
    private val requestRacerMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"
    private val requestPlayTimeMessage = "시도할 횟수는 몇 회인가요?"
    private val resultTextMessage = "실행 결과"
    fun printResultText(){
        println()
        println(resultTextMessage)
    }

    fun printRaceOnView(racerCrew: Racer){
        for (i in racerCrew.racerName.indices) {
            println("${racerCrew.racerName[i]} : ${"-".repeat(racerCrew.moveForward[i])}")
        }
        println()
    }

    fun printRequestRacer(){
        println(requestRacerMessage)
    }

    fun printRequestPlayTime(){
        println(requestPlayTimeMessage)
    }
}
