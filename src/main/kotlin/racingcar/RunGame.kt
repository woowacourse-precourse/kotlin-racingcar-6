package racingcar


class RunGame {

    fun startRace(){
        val preG = PrepareGame()
        var racingCars : MutableList<Players> = preG.makingPlayerList(preG.racingCarName())
        var racingNum: Int = preG.racingNumber()

        for( i in 1..racingNum){
            racingCars = repeatRace(racingCars.size,racingCars)
        }


        var winnerList:List<Players> = PostGame().getWinner(racingCars)
        PostGame().printWinner(winnerList)

    }

    fun repeatRace(numOfCar:Int,carList:MutableList<Players>):MutableList<Players>{

        for(i in 1..numOfCar){
            var eachNum:Int = RacingGame().randomRace()
            if(ifGoForward(eachNum)){
                carList[i].num=carList[i].num+1
            }
        }

        RacingGame().broadcastRace(carList.size, carList)
        return carList
    }

    fun ifGoForward(randomNum:Int):Boolean{

        if(randomNum>=4){return true}
        return false
    }



}