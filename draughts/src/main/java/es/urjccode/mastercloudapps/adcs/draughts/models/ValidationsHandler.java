package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class ValidationsHandler {

	protected Game game;
	protected ValidationsHandler nextValidationsHandler;
	protected Error error;

	protected ValidationsHandler(Game game) {
		this.game = game;
		this.nextValidationsHandler = null;
		this.error = null;
	}

	public abstract Error validate(Coordinate origin, Coordinate target);

	public Game getGame(){
		return this.game;
	}
}