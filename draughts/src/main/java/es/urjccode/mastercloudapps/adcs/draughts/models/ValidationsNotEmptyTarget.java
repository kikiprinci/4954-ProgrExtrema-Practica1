package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationsNotEmptyTarget extends ValidationsHandler {

    public ValidationsNotEmptyTarget(Game game) {
        super(game);
    }

    @Override
	public Error validate(Coordinate origin, Coordinate target) {
        if (!this.getGame().getBoard().isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		return this.error;
	}
}