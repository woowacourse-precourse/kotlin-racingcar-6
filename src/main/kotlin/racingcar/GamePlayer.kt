package racingcar

class GamePlay(gameNum : Int?, carList : List<String>?) {


    private var carScoreList = HashMap<String,Int>()
    private var _winnerList : MutableList<String> = mutableListOf()
    val winnerList =  _winnerList
    private var gameOrder  = 1

    init {


         carScoreList= makeListToHash(carList)


        while(gameOrder <= gameNum!!) {

            carScoreList = playGame(carScoreList)

            print("\n")

            gameOrder ++
        }

        _winnerList = selectWinner(carScoreList)



    }

    private fun makeListToHash(list : List<String>?) : HashMap<String,Int>{

        list?.forEach {
                carName ->
            carScoreList[carName] = 0
        }
        return carScoreList
    }

    private fun playGame(carScore : HashMap<String,Int>) : HashMap<String,Int> {

        carScore.forEach {

            val randomNumProducer = RandomNumProducer()
            val numResult = randomNumProducer.makeRandomNum()
            if(numResult >=4 ) carScore[it.key] = carScore[it.key]!! + 1
            printEachGameResult(it.key,it.value)

        }
        return carScore

    }




    private fun printEachGameResult(carName : String, carScore : Int){
        print(carName)
        print(" : ")
        for (i in 1..carScore){
            print("-")
        }
        print("\n")

    }

    private fun selectWinner(carScore: HashMap<String, Int>): MutableList<String> {

        val maxScore = carScore.maxByOrNull { it.value }?.value
        carScore.forEach {
            map ->
            if(map.value == maxScore) _winnerList.add(map.key)
        }

        return _winnerList
    }



}