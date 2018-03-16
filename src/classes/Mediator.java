package classes;

import javafx.stage.Stage;

public class Mediator {
    private static Mediator INSTANCE;

    private Stage stage;
    private Usuario user;

    public static Mediator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Mediator();
        }
        return INSTANCE;
    }

    private Mediator() {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}