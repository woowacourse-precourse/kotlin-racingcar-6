import camp.nextstep.edu.missionutils.Console

class User {
    var carNameList: List<String> = emptyList<String>()
    var tryCount: Int = 0

    fun inputCarNames() {
        print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)")
        var names = Console.readLine()
        separateCommas(names)
    }

    fun separateCommas(names: String) {
        val carNameList = names.split(",").toList()
    }

    fun inputTryCount() {
        print("시도할 횟수는 몇 회인가요?")
        this.tryCount = Console.readLine().toInt()
    }

}