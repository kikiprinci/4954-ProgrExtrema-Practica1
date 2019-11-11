package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends SubView {

    public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            this.console.write((i + 1) + "");
            for (int j = 0; j < DIMENSION; j++) {
                Color color = controller.getColor(new Coordinate(i, j));
                this.console.write(checkColorResult(color));
            }
            this.console.writeln((i + 1) + "");
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(MessageView.EMPTY.getMessage());
        for (int i = 0; i < DIMENSION; i++) {
            this.console.write((i + 1) + "");
        }
        this.console.writeln();
    }

    private String checkColorResult(Color color) {
        if (color == null) {
            return MessageView.COLORS_SHORT[2];
        } else {
            return MessageView.COLORS_SHORT[color.ordinal()];
        }
    }

}
