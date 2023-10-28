package racingcar.Model

class RaceState {

    fun oneRoundResult(carNames:List<String>,raceStatus: MutableMap<String, List<Boolean>>):MutableMap<String,List<Boolean>> {

        var roundScore = mutableListOf<Boolean>()


        for(i in carNames.indices) {

            var personalScore=ForwardOrWaitCheck().oneRoundPersonalScore()

            roundScore.add(personalScore)

            raceStatus[carNames[i]] = raceStatus[carNames[i]].orEmpty() + listOf(roundScore[i])
        }

        return raceStatus
    }

}