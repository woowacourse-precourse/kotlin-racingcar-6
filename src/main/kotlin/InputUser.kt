import camp.nextstep.edu.missionutils.Console
import java.util.Scanner

class InputUser {

    object GameMessage{
        const val defaultInputMent:String="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val gameCountMent:String="시도할 횟수는 몇 회인가요?"
    }
    private val scanner = Scanner(System.`in`)

    fun printlnMent(){
      println(GameMessage.defaultInputMent)
    }
    fun inputCarName():List<String>{
        val input=scanner.nextLine()
        val carNameList= mutableListOf<String>()
        carNameList.add(input.split(",").map{it.trim()}.toString())
        return carNameList
    }
    fun tryGameCount():Int{
        println(GameMessage.gameCountMent)
        val input=scanner.nextLine()
        return input.toInt()
    }
    //처음에는 input을 pair로 관리하였으나, 게임횟수와 이름 사이의 유기성이 적다고 판단하여 이름만 리스트에 add()
    fun createMap(){
    }
}