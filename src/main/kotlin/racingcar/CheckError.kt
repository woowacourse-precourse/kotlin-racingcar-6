package racingcar

fun nameErrorCheck(name: String) {
    nameLengthCheck(name)
    nameEmptyCheck(name)
}

fun nameLengthCheck(name :String){
    if (name.length >= 6) throw IllegalArgumentException("입력의 길이가 잘못되었습니다.")
}

fun nameEmptyCheck(name:String){
    if (name.isEmpty()) {
        throw IllegalArgumentException("공백은 안됩니다!")
    }
}

fun redundancyErrorCheck(names: List<String>) {
    if (names.size != names.distinct().size) {
        throw IllegalArgumentException("똑같은 이름이 있습니다.")
    }
}

fun numberTimesErrorCheck(number: String) {
    numberTimesEmptyCheck(number)
    numberTimesCharCheck(number)
}

fun numberTimesEmptyCheck(number : String){
    if (number.isEmpty()) {
        throw IllegalArgumentException("공백은 안됩니다!")
    }
}

fun numberTimesCharCheck(number:String){
    for (i in number.indices) {
        if (number[i] > '9' || number[i] < '0') {
            throw IllegalArgumentException("입력값에 숫자가 아닌 값이 있습니다.")
        }
    }
}