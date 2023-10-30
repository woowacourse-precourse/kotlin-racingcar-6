package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceMove (val moveChanceNumber: MutableList<Int> = mutableListOf()){
    fun getMoveNumber(racerNameSize: Int){
        for(i in 0 until racerNameSize){
            val stopOrForwardNumber = Randoms.pickNumberInRange(0, 9)
            moveChanceNumber.add(judgeMoveOrStop(stopOrForwardNumber))
        }
    }

    private fun judgeMoveOrStop(stopOrForwardNumber: Int): Int{
        return when (stopOrForwardNumber) {
            in 0..3 -> 0
            in 4..9 -> 1
            else -> throw IllegalArgumentException(Message.MoveError.messageText)
        }
    }
}