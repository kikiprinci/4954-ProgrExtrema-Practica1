package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsDiagonalDistance extends ValidationsHandler {

	public ValidationsDiagonalDistance(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		return this.error;
	}

}