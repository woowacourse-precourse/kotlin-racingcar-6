package racingcar.model

data class RacingCar(
    val name : String,
    var forwardCount : Int = 0
) {
    fun goOneStep(){
        forwardCount++
    }

}
