package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game {

	private Board board;

	private Turn turn;

	public Game() {
		this.turn = new Turn();
		this.board = new Board();
		initGame();
	}

	private void initGame() {
		for (int i = 0; i < this.board.getDimension(); i++) {
			for (int j = 0; j < this.board.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Piece piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.board.put(coordinate, piece);
				}
			}
		}
	}

	public Board getBoard() {
		return this.board;
	}

	public Turn getTurn() {
		return this.turn;
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= 2) {
				color = Color.BLACK;
			} else if (row >= 5) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Piece(color);
			}
		}
		return null;
	}

	public Error move(Coordinate origin, Coordinate target) {
		assert origin != null && target != null;
		Validations validations = new Validations(this);
		Error error = validations.validateMovements(origin, target);
		error = validations.validateMovements(origin, target);
		return checkValidations(error, origin, target);
	}

	private Error checkValidations(Error error, Coordinate origin, Coordinate target) {
		if (error == null) {
			this.getBoard().move(origin, target);
			this.getTurn().change();
			return null;
		}
		return error;
	}

	public Piece remove(Coordinate coordinate) {
		return this.getBoard().remove(coordinate);
	}

	public boolean isEmpty(Coordinate coordinate) {
		return this.getBoard().isEmpty(coordinate);
	}

	public Color getColor(Coordinate coordinate) {
		return this.getBoard().getColor(coordinate);
	}

	@Override
	public String toString() {
		return this.getBoard() + "\n" + this.turn;
	}

	public Color getColor() {
		return this.getTurn().getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.getBoard().getPiece(coordinate);
	}

	public boolean isBlocked() {
		return this.getBoard().getPieces(this.turn.getColor()).isEmpty();
	}

	public int getDimension() {
		return this.getBoard().getDimension();
	}

}