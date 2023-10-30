package racingcar.Model

class RaceState {

    fun oneRoundResult(carNames:List<String>): List<Boolean> {

        var oneRoundScore = mutableListOf<Boolean>()

        for(i in carNames.indices) {
            var personalScore = ForwardOrWaitCheck().oneRoundPersonalScore()
            oneRoundScore.add(personalScore)
        }
        return oneRoundScore
    }

    fun updateEntireRaceScore(carNames: List<String>, oneRoundResults: List<Boolean>, entireRaceStatus: MutableMap<String, List<Boolean>>): MutableMap<String, List<Boolean>> {

        for (i in carNames.indices) {
            entireRaceStatus[carNames[i]] = entireRaceStatus[carNames[i]].orEmpty() + listOf(oneRoundResults[i])
        }
        return entireRaceStatus
    }

}