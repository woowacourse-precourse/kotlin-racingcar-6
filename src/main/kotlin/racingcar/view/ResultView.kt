package racingcar.view

class ResultView {
    fun printWinner(carStatus: MutableMap<String, String>) {
        val longestDistance = carStatus.values.maxByOrNull { it.length }?.length
        val finalWinner = carStatus.filter { it.value.length == longestDistance }.keys
        print("최종 우승자 : " + finalWinner.joinToString(", "))
    }
}
