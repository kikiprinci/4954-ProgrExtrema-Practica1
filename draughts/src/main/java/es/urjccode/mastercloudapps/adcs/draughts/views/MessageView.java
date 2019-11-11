package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum MessageView {
    TITTLE("Las Damas!!!"), MESSAGERESUME("¿Queréis jugar otra"),
    MESSAGEPLAY("Derrota!!! No puedes mover tus fichas!!!"),
    ERROR("Error!!!"),MOVE("Mueven las "),EMPTY(" "),COLON(": ");

    private String message;
    public static final String[] COLORS = { "blancas", "negras" };
    public static final String[] COLORS_SHORT = new String[]{"b", "n", " "};

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}