package racingcar.service

interface PrintGame {
    //초기화 시 프린트 하는 메서드
    fun printInit()
    //시도할 횟수에 대한 프린트 하는 메서드
    fun tryCount()
    // 게임 진행시 결과를 프린트 하는 메서드
    fun printGame(playerName: String, goCount: Int)
    // 게임 승리자를 프린트 하는 메서드
    fun printWinner(names: List<String>)
}