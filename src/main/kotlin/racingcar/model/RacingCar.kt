package racingcar.model

data class RacingCar(
    //자동차 이름
    val name: String,
    //자동차 전진 횟수
    var forwardCount: Int = 0
) {
    fun goOneStep() {
        forwardCount++
    }

}
