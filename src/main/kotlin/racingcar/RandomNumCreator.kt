package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumCreator {
    private val inputManager = InputManager()

    fun creator() : List<Int>{
        val num = inputManager.readRepeatNum()
        val numList: MutableList<Int> = mutableListOf()
        for(index in 1..num){
            val randomNum = Randoms.pickNumberInRange(0, 9)
            numList.add(randomNum)
        }
        return numList
    }
}