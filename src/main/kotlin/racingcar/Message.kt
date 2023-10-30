package racingcar

enum class Message (val messageText: String){
    /* 입력 요청 메세지 */
    REQUEST_RACER_NAME("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_PLAY_TIME("시도할 횟수는 몇 회인가요?"),

    /* 사전 메세지 */
    RESULT_TEXT("실행 결과"),

    /* 에러 메세지 */
    MOVE_ERROR("자동차 이동 오류"),
    RACER_NAME_LENGTH_ERROR("자동차 이름은 5자를 초과할 수 있습니다."),
    RACER_NAME_BLANK_ERROR("자동차 이름은 공백이 될 수 없습니다."),
    RACER_NAME_RANGE_ERROR("자동차 이름은 1개부터 10개까지 입력할 수 있습니다."),
    RACE_TIME_RANGE_ERROR("이동 시도 횟수는 최소 1회, 최대 10회 입니다."),
    NO_CHAMPION_ERROR("이동 시도 결과 전진한 자동차가 없어 우승자가 존재하지 않습니다.")
}