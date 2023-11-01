package racingcar

class CarName (name:String){
    private var name:String
    init {
        this.name=name
        checkName()
    }
    private fun checkName(){
        if(name.length>5){
            throw IllegalArgumentException("자동차 이름을 5글자 이하로 설정해 주세요.")
        }else if(name.length<=0){
            throw IllegalArgumentException("자동차 이름을 작성해 주세요.")
        }
    }
    fun amount():String{
        return this.name
    }
}