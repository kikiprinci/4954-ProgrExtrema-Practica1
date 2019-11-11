package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Validations {

    private Game game;

    public Validations(Game game) {
        this.game = game;
    }

    public Error validateMovements(Coordinate origin, Coordinate target) {

        List<ValidationsHandler> lstValidates = new ArrayList<>();
        lstValidates.add(new ValidationsOutCoordinate(this.game));
        lstValidates.add(new ValidationsEmptyOrigin(this.game));
        lstValidates.add(new ValidationsOpposite(this.game));
        lstValidates.add(new ValidationsDiagonal(this.game));
        lstValidates.add(new ValidationsAdvanced(this.game));
        lstValidates.add(new ValidationsDiagonalDistance(this.game));
        lstValidates.add(new ValidationsNotEmptyTarget(this.game));
        lstValidates.add(new ValidationsEat(this.game));

        for (ValidationsHandler validationsHandler : lstValidates) {
            Error error = validationsHandler.validate(origin, target);
            if (error != null)
                return error;
        }
        return null;
    }
}