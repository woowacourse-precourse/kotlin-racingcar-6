package racingcar.exception

class IllegalNumberException : IllegalArgumentException() {

    override val message: String?
        get() = "올바른 숫자를 입력해주세요."
}