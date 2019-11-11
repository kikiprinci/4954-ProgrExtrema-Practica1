package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends WithConsoleView {

    private GameView gameView;

    public PlayView() {
        super();
        gameView = new GameView();
    }

    public void interact(PlayController playController) {
        String color = MessageView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        do {

            String command = this.console
                    .readString(MessageView.MOVE.getMessage() + color + MessageView.COLON.getMessage());
            error = playController.move(new Coordinate(command.substring(0, 2)),
                    new Coordinate(command.substring(3, 5)));
            checkEndGame(playController, error);
        } while (error != null);
        checkIsBlocked(playController);
    }

    private void checkIsBlocked(PlayController playController) {
        if (playController.isBlocked()) {
            this.console.write(MessageView.MESSAGEPLAY.getMessage());
        }
    }

    private void checkEndGame(PlayController playController, Error error) {
        if (error != null) {
            console.writeln(MessageView.ERROR.getMessage() + error.name());
            gameView.write(playController);
        }
    }

}