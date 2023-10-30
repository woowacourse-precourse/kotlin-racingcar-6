package racingcar

fun main(){
    val view = RacingCarView()
    val model = RacingCarModel()
    val controller = RacingCarController(view, model)

    controller.race()
}

