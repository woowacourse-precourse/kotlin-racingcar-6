package racingcar

class RacingResult {
    fun gameResult(cars:List<String>, race:List<String>){
        for(i: Int in cars.indices){
            println(cars[i] + " : " + race[i])
        }
    }
    fun winnerResult(cars:List<String>, race:List<String>){
        val index = mutableListOf<Int>()
        var nowMax:Int = 0
        for(i in race.indices){
            if(nowMax<race[i].length){
                nowMax = race[i].length
                index.clear()
                index.add(i)
            }
            else if(nowMax==race[i].length){
                index.add(i)
            }
        }
        print("최종 우승자 : ")
        for(winner in 0 until index.size){
            print(cars[index[winner]])
            if (winner < index.size - 1) {
                print(", ")
            }
        }

    }
}