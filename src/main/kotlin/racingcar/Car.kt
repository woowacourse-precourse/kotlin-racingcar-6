package racingcar

class Car(val name: String) {

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("차의 이름은 5자 이하만 가능합니다.")
        }
    }

}