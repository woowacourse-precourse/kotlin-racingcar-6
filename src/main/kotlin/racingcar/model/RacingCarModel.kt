package racingcar.model

class RacingCarModel(val name: String) {

    private val randomNumberGenerator = RandomNumberGenerator()
    var place = 0
        set(value) {
            if (value < place) return
            else place = value
        }


    fun tryToMove() {
        if (randomNumberGenerator.generate() >= 4)  place++
    }

}