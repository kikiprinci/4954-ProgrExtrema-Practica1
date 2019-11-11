package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsAdvanced extends ValidationsHandler {

	public ValidationsAdvanced(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		Piece piece = this.getGame().getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		return this.error;
	}

}