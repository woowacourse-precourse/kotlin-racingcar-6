import java.util.Scanner

class InputUser {
    object GameMessage{
        const val defaultInputMent:String="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val gameCountMent:String="시도할 횟수는 몇 회인가요?"
    }

    fun printlnMent(){
      println(GameMessage.defaultInputMent)
    }
    fun inputCarName(){
        val scanner= Scanner(System.`in`)
        val input=scanner.nextLine()
        println("${input.toString()}")
    }
    fun printlnGameCount(){
        println(GameMessage.gameCountMent)
    }

}