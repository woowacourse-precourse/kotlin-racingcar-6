package racingcar.View

class RaceViewer {

    fun roundResultViewer(raceStatus: MutableMap<String, List<Boolean>>){

        for ((carName, roundResults) in raceStatus) {

            var score=roundResults.count{ it }

            val scoreLine="-".repeat(score)

            println("$carName : $scoreLine")
        }
        println("")
    }

    fun winnerViewer(winner:List<String>){

        println("최종 우승자 : ${winner.joinToString(", ")}")
    }

}