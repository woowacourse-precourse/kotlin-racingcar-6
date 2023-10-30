package racingcar

class Validator {
    fun validateString(string: String){
        val regexStr = """[^-:?!@#$}{%^&*()+=~\\|`/\\s\\]\\['\"]""".toRegex()
        regexStr.matches(string)
    }
}