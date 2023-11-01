package racingcar.view

import racingcar.res.GAME_RESULT
import racingcar.res.GAME_RESULT_USER
import racingcar.res.GAME_START_MESSAGE
import racingcar.res.GAME_TRY_NUMBER
import kotlin.text.StringBuilder

object Prompter {
    fun startGame(){
        println(GAME_START_MESSAGE)
    }
    fun tryGameNumber(){
        println(GAME_TRY_NUMBER)
    }

    fun resultGame(){
        println()
        println(GAME_RESULT)
    }

    fun showEachTry(scoreMap: MutableMap<String, Int>, user: List<String>){
        for (car in user){
            println("$car : ${printDash(scoreMap[car]!!)}")
        }
        println()
    }

    fun showWinner(winnerList: List<String>){
        val sb = StringBuilder()
        sb.append(winnerList.first())
        for(index in 1 until winnerList.size){
            sb.append(",").append(winnerList[index])
        }
        println("$GAME_RESULT_USER : $sb")
    }

    private fun printDash(times: Int): StringBuilder{
        val sb = StringBuilder()
        for(i in 1..times){
            sb.append("-")
        }
        return sb
    }


}