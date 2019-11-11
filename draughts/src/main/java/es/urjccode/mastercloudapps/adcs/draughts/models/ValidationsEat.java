package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsEat extends ValidationsHandler {

	public ValidationsEat(Game game) {
		super(game);
	}

	@Override
	public Error validate(Coordinate origin, Coordinate target) {
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.getGame().getBoard().getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
			this.getGame().getBoard().remove(between);
		}
		return this.error;
	}
}