package racingcar.ui

object Validator {

    fun checkNamesLength(names: List<String>) {
        names.forEach { require(it.length <= 5) { "이름은 5자 이하만 가능합니다." } }
    }
}