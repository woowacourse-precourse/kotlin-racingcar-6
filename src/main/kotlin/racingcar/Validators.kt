package racingcar

fun verifyCarList(carList: List<String>) {
    require(carList.size == carList.distinct().size) { "자동차 이름은 중복될 수 없습니다." }
    carList.forEach { verifyCarName(it) }
}

fun verifyCarName(name: String) {
    val minNameLength = 1
    val maxNameLength = 5

    require(name.length >= minNameLength) { "1자 이상의 자동차 이름을 입력하세요." }
    require(name.length <= maxNameLength) { "5자 이하의 자동차 이름을 입력하세요." }
}