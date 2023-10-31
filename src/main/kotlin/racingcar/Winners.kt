package racingcar

class Winners {
    private lateinit var longDistance: String

    // 우승 자동차 찾기
    fun findWinners(carNamesAndResults: Map<String, String>): List<String> {
        longDistance = carNamesAndResults.maxBy { it.value }.value
        return carNamesAndResults.filter { it.value == longDistance }.keys.toList() // 가장 많이 전진한 자동차들 이름 반환
    }
}