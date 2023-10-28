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


}