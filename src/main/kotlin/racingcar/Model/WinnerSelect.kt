package racingcar.Model

class WinnerSelect {

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