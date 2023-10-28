package racingcar

class Car(val name: String) {

    private var _distance = 0
    val distance: Int get() = _distance

    init {
        require(name.isNotBlank() && name.length < 5) { Error.InvalidName }
    }

    fun moveForward() {
        _distance++
    }

    internal enum class Error(private val message: String) {
        InvalidName("닉네임이 올바르지 않습니다. 이름은 5자 이하로 입력해주세요.");

        override fun toString() = message
    }
}