import camp.nextstep.edu.missionutils.Console
import java.util.Scanner

class InputUser {

    object GameMessage{
        const val defaultInputMent:String="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val gameCountMent:String="시도할 횟수는 몇 회인가요?"
    }
    fun printlnMent(){
      println(GameMessage.defaultInputMent)
    }
    fun inputCarName(): List<String> {
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }
    fun printlnGameCountMent(){
        println(GameMessage.gameCountMent)

    }
    fun tryGameCount():Int{
            val input = Console.readLine()
            return input.toInt()
    }
    fun validName(carName:List<String>):Boolean{
        for(name in carName.indices){
            if(carName[name].length>=5) {
                throw IllegalArgumentException("5글자를 초과한 이름은 입력 불가합니다.")
                return false
            }
        }
        return true
    }
}