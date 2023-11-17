import camp.nextstep.edu.missionutils.Console
import java.util.Scanner

class InputUser {

    object GameMessage{
        const val defaultInputMent:String="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val gameCountMent:String="시도할 횟수는 몇 회인가요?"
    }
  init{
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
            if(input.toIntOrNull()==null){
                throw IllegalArgumentException("[Error]게임 횟수는 숫자로만 입력해야합니다.")
            }
        return input.toInt()
    }
    fun validName(carName:List<String>):Boolean{
        if(carName.filter{it.length>=5}.isNotEmpty()){
            throw IllegalArgumentException("[Error]5글자를 초과하는 이름이 입력되었습니다.")
        }
        return true
    }
}