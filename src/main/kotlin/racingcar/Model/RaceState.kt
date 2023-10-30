package racingcar.Model

class RaceState {

    fun oneRoundResult(carNames: List<String>): List<Boolean> {

        var oneRoundScore = mutableListOf<Boolean>()

        for (i in carNames.indices) {
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

    fun compareScore(entireRaceStatus: MutableMap<String, List<Boolean>>):MutableMap<String,Int> {

        var finalScore=mutableMapOf<String,Int>()
        var personalScore:Int

        for ((carName, roundResults) in entireRaceStatus) {
            personalScore=roundResults.count{ it }
            finalScore[carName] = personalScore
        }
        return finalScore
    }

    fun raceWinnerSelect(finalScore: MutableMap<String,Int>): MutableList<String> {
        var winners = mutableListOf<String>()
        var maxScore = finalScore.maxBy { it.value }

        for (i in finalScore) {
            if (i.value == maxScore.value) {
                winners.add(i.key)
            }
        }
        return winners
    }
}