package racingcar.model

class CarNameSeparator {
    fun separator(names: String) :List<String>{
        var separatedName: MutableList<String> = mutableListOf()
        var carName: String = ""
        for (word in names) {
            if (word == Constants.COMMA) {
                separatedName.add(carName)
                carName = ""
            } else {
                carName += word
            }
        }
        return separatedName
    }
}