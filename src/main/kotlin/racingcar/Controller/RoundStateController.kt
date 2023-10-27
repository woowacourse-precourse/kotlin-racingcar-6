package racingcar.Controller

class RoundStateController {

    fun oneRoundResult(carNames:List<String>):List<Boolean> {

        var roundScore = mutableListOf<Boolean>()

        for(i in 1..carNames.size)
        {
            var randomNumbers=ForwardConditionController().randomNumberGenerator()
            var roundResult=ForwardConditionController().numberResultJudgment(randomNumbers)
            roundScore.add(roundResult)
        }
        return roundScore
    }

    fun placementOfScores(carNames:List<String>,oneRoundResults:List<Boolean>,raceStatus: MutableMap<String, List<Boolean>>):MutableMap<String,List<Boolean>> {

        for(i in carNames.indices){
            raceStatus[carNames[i]] = raceStatus[carNames[i]].orEmpty() + listOf(oneRoundResults[i])
        }
        return raceStatus
    }
}