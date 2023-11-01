package racingcar

class GameManager(
    val nameList: List<String>,
    val tryCount: Int,
    var carsList: MutableList<Car>
) {
    constructor(nameList: List<String>, tryCount: Int) : this(nameList, tryCount, mutableListOf()) {
        createCarList(nameList)
    }

    private fun createCarList(nameList: List<String>) {
        for (name in nameList) {
            this.carsList.add(Car(name, ""))
        }
    }

    fun raceStart(){
        println("실행 결과")
        for (round in 0 until tryCount) {
            // 각 자동차는 난수를 뽑아 전진을 시도
            // 각 자동차의 이동 거리를 출력
            println()
        }
    }
}