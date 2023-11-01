package racingcar.model

class Car (name: String){
    val name: String
    var distance: Int = 0

    init {
        require(name.length in 1..5) { "5자 이하의 이름이 아닙니다." }
        require(name.isNotEmpty()) { "이름을 입력해주세요." }
        this.name = name
    }

    fun moved() {
        distance++
    }
}