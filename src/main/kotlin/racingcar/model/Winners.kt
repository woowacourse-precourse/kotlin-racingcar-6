package racingcar.model

class Winners (winnersList: MutableList<Car>){
    private var winners: MutableList<Car> = mutableListOf()

    init {
        this.winners = winnersList
    }
}