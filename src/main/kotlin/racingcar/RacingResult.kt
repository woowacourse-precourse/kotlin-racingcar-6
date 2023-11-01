package racingcar

class RacingResult {
    companion object {
        val instance = RacingResult()
    }
    fun gameResult(cars: List<String>, race: List<String>) {
        //var result:String = "" // 테스트 코드용
        for(i: Int in cars.indices){
            println("${cars[i]} : ${race[i]}")
            //result += (cars[i] + " : " + race[i] + "\n") // 테스트 코드용
        }
        //return result // 테스트 코드용
    }
    fun winnerFind(race:List<String>) : MutableList<Int> {
        val index = mutableListOf<Int>()
        var nowMax: Int = 0
        for (i in race.indices) {
            if (nowMax < race[i].length) {
                nowMax = race[i].length
                index.clear()
                index.add(i)
            } else if (nowMax == race[i].length) {
                index.add(i)
            }
        }
        return index
    }
    fun winnerResult(cars: List<String>, race: List<String>) {
        print("최종 우승자 : ")
        //var winners = "최종 우승자 : " // 테스트 코드용
        val index = winnerFind(race)
        for (winner in 0 until index.size) {
            print(cars[index[winner]])
            //winners += cars[index[winner]] // 테스트 코드용
            if (winner < index.size - 1) {
                print(", ")
                //winners += ", " // 테스트 코드용
            }
        }
        //return winners // 테스트 코드용

    }
}