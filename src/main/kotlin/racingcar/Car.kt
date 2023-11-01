package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car (name:String){
    val carName = name
    private var randomNum = 0
    private var moveCnt = 0

    fun getRandomNum(){
        randomNum = Randoms.pickNumberInRange(1,9)
    }

    private fun isGo(){
        if(randomNum >=4){
            moveCnt++
        }
    }
}