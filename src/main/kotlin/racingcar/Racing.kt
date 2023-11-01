package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class Racing {

    fun enterMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = Console.readLine()
        println("")
        return try {
            moveCount!!.toInt()
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("정수를 입력해 주세요.")
        }
    }

    fun validatePositiveInteger(moveCount: Int) {
        if (moveCount <= 0) {
            throw IllegalArgumentException("1 이상의 정수를 입력해주세요.")
        }
    }

    fun determineProgress(carProgressList : MutableList<Int>): MutableList<Int>{
        for (i in 0..<carProgressList.size){
            if (validateMoveCondition(createRandomNumber())){
                carProgressList[i]+=1
            }
        }
        return carProgressList
    }

    fun createRandomNumber(): Int{
        return Randoms.pickNumberInRange(0, 9)
    }

    fun validateMoveCondition(number : Int) : Boolean {
        return number>=4
    }
}