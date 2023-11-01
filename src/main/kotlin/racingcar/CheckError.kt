package racingcar

fun nameErrorCheck(name: String) {
    nameLengthCheck(name)
    nameEmptyCheck(name)
}

fun nameLengthCheck(name: String) {
    if (name.length >= NAME_OVER_LENGTH) {
        throw IllegalArgumentException(LENGTH_ERROR)
    }
}

fun nameEmptyCheck(name: String) {
    if (name.isEmpty()) {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun redundancyErrorCheck(names: List<String>) {
    if (names.size != names.distinct().size) {
        throw IllegalArgumentException(SAME_ERROR)
    }
}

fun numberTimesErrorCheck(number: String) {
    numberTimesEmptyCheck(number)
    numberTimesDigitCheck(number)
}

fun numberTimesEmptyCheck(number: String) {
    if (number.isEmpty()) {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun numberTimesDigitCheck(number: String) {
    if (!number.all { it.isDigit() }) {
        throw IllegalArgumentException(NUMBER_ERROR)
    }
}