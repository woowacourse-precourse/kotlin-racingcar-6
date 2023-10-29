package racingcar

class RacingCarModel(
    var racerCrew: Racer = Racer()
) {
    fun requestUpdateRacerName(racerName: MutableList<String>){
        racerCrew.updateRacerName(racerName)
    }

    fun requestUpdatePlayTime(playTime: Int){
        racerCrew.updatePlayTime(playTime)
    }

    fun judgeRace(sequence: Int){

    }

    fun requestPrintRace(){

    }

}