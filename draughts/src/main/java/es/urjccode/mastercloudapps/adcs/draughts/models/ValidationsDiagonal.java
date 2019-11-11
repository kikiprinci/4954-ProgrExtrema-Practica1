package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsDiagonal extends ValidationsHandler {

	public ValidationsDiagonal(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		return this.error;
	}

}