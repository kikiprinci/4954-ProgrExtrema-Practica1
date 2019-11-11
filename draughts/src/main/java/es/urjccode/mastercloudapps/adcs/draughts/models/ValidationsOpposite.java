package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsOpposite extends ValidationsHandler {

	public ValidationsOpposite(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		Color color = this.game.getColor(origin);
		if (this.getGame().getColor() != color) {
			return Error.OPPOSITE_PIECE;
		}
		return this.error;
	}

}