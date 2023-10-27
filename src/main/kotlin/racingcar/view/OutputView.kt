package racingcar.view

class OutputView {
    private fun printProgress() {
        println("실행 결과")
        // TODO 시도할 횟수만큼의 실행 결과 출력
    }

    private fun printWinner() {
        print("최종 우승자 : ")
        // TODO 우승자 출력
    }

    fun gameResult() {
        printProgress()
        printWinner()
    }
}