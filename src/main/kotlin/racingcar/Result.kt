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

}