package racingcar

class RacingCarView() {
    fun printRaceOnView(racerCrew: Racer){
        for (index in racerCrew.racerName.indices) {
            val personalMoveResult = "${racerCrew.racerName[index]} : ${"-".repeat(racerCrew.moveDistance[index])}"
            println(personalMoveResult)
        }
        println()
    }

    fun printChampionOnView(raceChampion: Champion){
        val championName = raceChampion.championName.joinToString(", ")
        val announceChampion = "최종 우승자 : $championName"
        println(announceChampion)
    }

    fun printResultText(){
        println()
        println(Message.RESULT_TEXT.messageText)
    }

    fun printRequestRacer(){
        println(Message.REQUEST_RACER_NAME.messageText)
    }

    fun printRequestPlayTime(){
        println(Message.REQUEST_PLAY_TIME.messageText)
    }
}
