package racingcar.service

interface PlayGame {
    // 게임 셋팅
    fun initGame()
    // 플레이어 값 초기화
    fun initPlayers(names: List<String>)
    // 게임의 전체 진행을 위한 메서드
    fun playGame()
    // 게임의 각 라운드를 위한 메서드
    fun playRound()
    // 게임 종료시 호출될 메서드
    fun endGame(winnerCount: Int)
}