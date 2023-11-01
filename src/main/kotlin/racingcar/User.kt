import camp.nextstep.edu.missionutils.Console

class User {
    var carNameList: List<String> = emptyList<String>()

    fun inputCarNames() {
        print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)")
        var names = Console.readLine()
    }

    fun separateCommas(names: String) {
        val carNameList = names.split(",").toList()
    }

}