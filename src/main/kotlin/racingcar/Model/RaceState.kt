package racingcar.Model

class RaceState {

    fun createRoundResult(carNames:List<String>): List<Boolean> {

        val roundScore = mutableListOf<Boolean>()

        for(i in carNames.indices) {
            val personalScore = ForwardOrWaitCheck().oneRoundPersonalScore()
            roundScore.add(personalScore)
        }
        return roundScore
    }
    fun updateEntireRaceScore(carNames: List<String>,
                              oneRoundResults: List<Boolean>,
                              entireRaceStatus: MutableMap<String,
                                      List<Boolean>>): MutableMap<String, List<Boolean>> {

        for (i in carNames.indices) {
            entireRaceStatus[carNames[i]] = entireRaceStatus[carNames[i]].orEmpty() + listOf(oneRoundResults[i])
        }
        return entireRaceStatus
    }

}