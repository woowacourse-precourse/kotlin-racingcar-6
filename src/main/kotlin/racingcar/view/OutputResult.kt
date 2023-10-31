package racingcar.view

class OutputResult {
    fun showResult(cars: List<String>) {
        print("최종 우승자 : ${cars.joinToString(", ")}")
    }
}