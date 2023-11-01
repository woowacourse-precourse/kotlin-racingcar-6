import camp.nextstep.edu.missionutils.Randoms

class Car {
    var name: String = ""
    var score: Int = 0

    constructor(name: String) {
        this.name = name
    }

    fun confirmProgress(): Boolean {
        var randomNumber = Randoms.pickNumberInRange(0, 9)
        
        if (randomNumber >= 4) {
            return true
        }
        return false
    }

    fun progressScore() {
        this.score += 1
    }
    
}