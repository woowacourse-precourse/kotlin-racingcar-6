package racingcar.model

class CarNameSeparator {
    fun separator(names: String) :List<String>{
        var separatedName: MutableList<String> = mutableListOf()
        var carName = Constants.EMPTY_SPACE
        for (word in names) {
            if (word == Constants.COMMA) {
                separatedName.add(carName)
                carName = Constants.EMPTY_SPACE
                continue
            }
            carName += word
        }
        separatedName.add(carName)
        return separatedName
    }
}