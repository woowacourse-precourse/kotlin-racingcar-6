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
        println(Message.ResultText.messageText)
    }

    fun printRequestRacer(){
        println(Message.RequestRacerName.messageText)
    }

    fun printRequestPlayTime(){
        println(Message.RequestPlayTime.messageText)
    }
}
