package racingcar.view

object RaceResultView {

    private const val FINAL_WINNER = "최종 우승자 : "
    fun printRoundResult(result:String){
        println(result)
    }

    fun printWinners(winners:String){
        println("$FINAL_WINNER$winners")
    }
}