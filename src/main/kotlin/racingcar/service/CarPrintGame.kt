package racingcar.service


class CarPrintGame : PrintGame {
    override fun printInit() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    override fun tryCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun printGame(playerName: String, goCount: Int) {
        print("$playerName : ")
        for (loop in 0..<goCount) {
            print("-")
        }
        println()
    }

    override fun printWinner(names: List<String>) {
        print("최종 우승자 : ")
        //마지막에서 한명을 제외하고 ", " 형식으로 뽑기위해서 -2를 사용한다
        for (loop in 0..<names.lastIndex) {
            print("${names[loop]}, ")
        }
        print(names.last())
    }
}