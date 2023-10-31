package racingcar


class RunGame {

    fun startRace(){
        val pG = PrepareGame()
        var racingCars : MutableList<Players> = pG.makingPlayerList(pG.racingCarName())
        var racingNum: Int = pG.racingNumber()

        for( i in 1..racingNum){
            repeatRace(racingCars.size,racingCars)
        }


        var winnerList:ArrayList<String> = PostGame().getWinner()
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