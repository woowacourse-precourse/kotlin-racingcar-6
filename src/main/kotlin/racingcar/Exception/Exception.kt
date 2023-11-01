import racingcar.Exception.Strings
import racingcar.Exception.Strings.EXCEPTION_CAR_NAME_LENGTH

object carExceptions {

    fun checkInputIsValid(input: String?): RacingGameModel {
        checkInputIsNull(input)

        val carNames = input!!.split(",").map { it.trim() }.filter { it.isNotBlank() }

        checkCarNamesMoreThanOne(carNames)
        checkCarNamesLength(carNames)
        checkCarNameIsDoubled(carNames)

        val cars = carNames.map { Car(it, 0) }

        val racingGameModel = RacingGameModel()
        cars.forEach { racingGameModel.addCar(it) }

        return racingGameModel

    }

    fun checkCarNamesLength(carNames: List<String>) {
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException(EXCEPTION_CAR_NAME_LENGTH)
        }
    }

    fun checkCarNamesMoreThanOne(carNames: List<String>){
        if (carNames.size < 2){
            throw IllegalArgumentException(Strings.EXCEPTION_MORE_THAN_ONE_CAR_NAME)
        }
    }

    fun checkInputIsNull(Input: String?){
        if(Input==null){
            throw IllegalArgumentException(Strings.EXCEPTION_MORE_THAN_ONE_CAR_NAME)
        }
    }

    fun checkCarNameIsDoubled(carNameList: List<String>){
        if (carNameList.size != carNameList.distinct().size) {
            throw IllegalArgumentException(Strings.EXCEPTION_CAR_NAME_IS_DOUBLED)
        }
    }
}

object playTimeExceptions {

    fun checkPlayTimeIsInvalid(playTime:String?):Int{
        try {
            val playTimeAsInt = playTime!!.toInt()
            return checkPlayTimeIsNegative(playTimeAsInt)

        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Strings.EXCEPTION_PLAYTIME_IS_INVALID)
        }
    }

    fun checkPlayTimeIsNegative(playTime:Int) : Int{
        if (playTime< 0) {
            throw IllegalArgumentException(Strings.EXCEPTION_PLAYTIME_IS_NEGATIVE)
        }
        return playTime
    }
}