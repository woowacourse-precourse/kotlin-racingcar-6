package racingcar.model

class CarNameSeparator {
    fun separator(names: String): List<String> {
        return names.split(Constants.COMMA.toString())
    }
}