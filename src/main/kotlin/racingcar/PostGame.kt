package racingcar

class PostGame {
    fun getWinner(carList:MutableList<Players>):List<Players>{
        val winnerCar : Int = carList.maxBy {it.num}.num
        var winnerList = carList.filter { it.num == winnerCar }

        return winnerList
    }
}

