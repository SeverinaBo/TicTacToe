public enum ResultType {
    PLAYER_WINS("Congratulations you won!"),
    COMPUTER_WINS("Computer Wins"),
    DRAW("You are equally smart");

    private final String message;

    ResultType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
