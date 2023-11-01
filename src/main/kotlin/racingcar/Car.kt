package racingcar

class Car(val name:String) {
    var progress: Int = 0

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if(name.length > 5) {
            throw IllegalArgumentException("잘못된 이름을 입력하였습니다.")
        }
        if(name.contains(" ")) {
            throw IllegalArgumentException("잘못된 이름을 입력하였습니다.")
        }
    }
}