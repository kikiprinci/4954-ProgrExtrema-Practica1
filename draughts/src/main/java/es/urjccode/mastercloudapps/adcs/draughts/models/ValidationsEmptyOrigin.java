package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsEmptyOrigin extends ValidationsHandler {

	public ValidationsEmptyOrigin(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		if (this.getGame().isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		return this.error;
	}

}