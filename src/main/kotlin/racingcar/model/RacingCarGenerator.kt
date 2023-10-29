package racingcar.model

class RacingCarGenerator(private val name:String) : CarGenerator {

    override fun generate() = RacingCarModel(name)
}