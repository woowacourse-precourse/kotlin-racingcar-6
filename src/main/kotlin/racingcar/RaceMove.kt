package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceMove (val moveChanceNumber: MutableList<Int> = mutableListOf()){
    fun getMoveNumber(racerNameSize: Int){
        for(i in INITIALIZATION until racerNameSize){
            val stopOrForwardNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM)
            moveChanceNumber.add(judgeMoveOrStop(stopOrForwardNumber))
        }
    }

    private fun judgeMoveOrStop(stopOrForwardNumber: Int): Int{
        return when (stopOrForwardNumber) {
            in STOP_MINIMUM..STOP_MAXIMUM -> STOP
            in MOVE_MINIMUM..MOVE_MAXIMUM -> MOVE
            else -> throw IllegalArgumentException(Message.MoveError.messageText)
        }
    }
}