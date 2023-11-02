package racingcar

class Result {

    fun printProgress(carNames : List<String>,carProgressList : MutableList<Int>) {
        for (i in carNames.indices){
            print(carNames[i]+" : ")
            drawProgress(carProgressList[i])
            println("")
        }
        println("")
    }

    fun drawProgress(progress : Int){
        for (i in 0..<progress){
            print("-")
        }
    }

    fun printWinner(carNames: List<String>, carProgressList: MutableList<Int>): String {
        val max = carProgressList.max()
        val list: MutableList<String> = mutableListOf()
        for (i in carNames.indices) {
            if (max == carProgressList[i]) {
                list.add(carNames[i])
            }
        }
        return list.joinToString(", ")
    }
}