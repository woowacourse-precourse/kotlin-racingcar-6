package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(var name:String) {
    var count = 0
    fun move(number:Int){
        if (number >= 4){
            count += 1
        }
    }


    override fun toString():String{
        return "$name : ${"-".repeat(count)}"
    }
}