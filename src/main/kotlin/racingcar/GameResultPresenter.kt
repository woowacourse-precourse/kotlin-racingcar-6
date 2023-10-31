package racingcar

class GameResultPresenter {

    fun showWinners(cars: Cars) {
        print(WINNER_INFO)
        cars.showWinners()
    }

    companion object {
        const val WINNER_INFO = "최종 우승자 : "
    }
}