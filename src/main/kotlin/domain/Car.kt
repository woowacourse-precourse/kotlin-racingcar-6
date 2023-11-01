package domain

class Car(private var name: String) {
    var moveCount = 0

    fun moveForward(): Int {
        moveCount++
        return moveCount
    }

    fun moveStop(): Int {
        return moveCount
    }

    // 해결하는데 오래 걸린 부분 -> 객체가 저장된 위치를 반환하고 있었기 때문에 객체의 정보를 받기 위해서 사용
    override fun toString(): String {
        return "${name}"
    }
}
