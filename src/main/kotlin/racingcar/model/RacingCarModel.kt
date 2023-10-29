package racingcar.model

class RacingCarModel(val name: String) {

    private val randomNumberGenerator = RandomNumberGenerator()
    var place = 0
        set(value) {
            if (value < place) return
            else place = value
        }


    fun tryToMove() {
        if (randomNumberGenerator.generate() >= MIN_NUMBER_OF_MOVE)  place++
    }

    companion object{
        const val MIN_NUMBER_OF_MOVE = 4
    }

}