package racingcar.exception

class IllegalNameException : IllegalArgumentException() {
    override val message: String?
        get() = "자동차의 이름은 5자 이하만 가능합니다."
}