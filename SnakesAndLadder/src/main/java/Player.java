public class Player {
    String id;
    int currentPosition;

    public Player(String id, int currentPosition){
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getId() {
        return id;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
