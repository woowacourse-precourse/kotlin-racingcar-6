package racingcar

class inputNames(input: String) {
    private val names: List<String> = input.split(",").map { it.trim() }
    init {
        require(names.size <= 3) { "최대 3개의 이름을 입력하세요." }
        names.forEach {
        require(it.length <= 5) { "각 이름은 5자 이하로 입력하세요." }
        }
    }

    fun getNames(): List<String> {
        return names
}}