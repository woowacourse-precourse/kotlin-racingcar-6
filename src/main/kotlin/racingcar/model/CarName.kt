package racingcar.model

class CarName {
    fun separator(names: String): List<String> {
        return names.split(Constants.COMMA.toString())
    }
}