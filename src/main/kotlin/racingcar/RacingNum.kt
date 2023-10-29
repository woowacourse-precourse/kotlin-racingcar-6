package racingcar

class RacingNum(racingNum:Int) {
    private val racingNum : Int
    init {
        this.racingNum=racingNum
        checkNum()
    }
    private fun checkNum(){
        if(racingNum<=0){
            throw IllegalArgumentException("1회 이상을 선택해 주세요.")
        }
    }
    fun amount():Int{
        return racingNum
    }
}