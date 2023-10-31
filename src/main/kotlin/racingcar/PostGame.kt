package racingcar

class PostGame {
    fun getWinner(carList:MutableList<Players>):List<Players>{
        val winnerCar : Int = carList.maxBy {it.num}.num
        var winnerList = carList.filter { it.num == winnerCar }

        return winnerList
    }

    fun printWinner(carList:List<Players>){
        print("최종 우승자 : ")
        for( i in carList.indices){
            print(carList[i].name)
            if(i!=carList.size){
                print(", ")
            }
        }

    }
}

