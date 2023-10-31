package racingcar

class GamePlayer(gameNum : Int?, carList : List<String>?) {


    private var carScore = HashMap<String,Int>()
    private var winnerList : MutableList<String> = mutableListOf()


    init {
        carList?.forEach {
            carName ->
            carScore[carName] = 0
        }
        var gameOrder  = 1

        while(gameOrder<= gameNum!!) {

            carScore = playGame(carScore)
            print("\n")

            gameOrder ++
        }

        val maxScore = carScore.maxByOrNull { it.value }
        println(maxScore?.value)
    }



    fun playGame(carScore : HashMap<String,Int>) : HashMap<String,Int> {

        carScore.forEach {

            val randomNumProducer = RandomNumProducer()
            val numResult = randomNumProducer.makeRandomNum()
            if(numResult >=4 ) carScore[it.key] = carScore[it.key]!! + 1
            printEachGameResult(it.key,it.value)

        }
        return carScore

    }

    fun printEachGameResult(carName : String, carScore : Int){
        print(carName)
        print(" : ")
        for (i in 1..carScore){
            print("-")
        }
        print("\n")

    }

    fun selectWinner(carScore: HashMap<String, Int>){

        val maxScore = carScore.maxByOrNull { it.value }?.value
        carScore.forEach {
            map ->
            if(map.value == maxScore) winnerList.add(map.key)
        }
    }



}