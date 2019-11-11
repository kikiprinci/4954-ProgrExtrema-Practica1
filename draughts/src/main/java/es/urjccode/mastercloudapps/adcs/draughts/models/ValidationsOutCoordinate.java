package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsOutCoordinate extends ValidationsHandler {

	public ValidationsOutCoordinate(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		if (!origin.isValid() || !target.isValid()) {
			return Error.OUT_COORDINATE;
		}
		return this.error;
	}

}