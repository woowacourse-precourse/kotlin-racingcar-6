package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car (val name:String){
    val carName = name
    private var randomNum = 0
    private var moveCnt = 0

    fun getRandomNum(){
        randomNum = Randoms.pickNumberInRange(1,9)
    }

    fun isGo(){
        if(randomNum >=4){
            moveCnt++
        }
    }
    fun curLocation(){
        println(carName+" : " +"-".repeat(moveCnt))
    }
    fun getMoveCnt(): Int {
        return moveCnt
    }
}