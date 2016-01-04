package uppgift2;

public class CalcDao {
	String _operator;
	double _answere;

	public String get_operator() {
		return _operator;
	}

	public void set_operator(String _operator) {
		this._operator = _operator;
	}

	public double get_answere() {
		return _answere;
	}

	public void set_answere(double _answere) {
		this._answere = _answere;
	}

	public CalcDao() {
	}

	public CalcDao(String op, double answere) {
		this._operator = op;
		this._answere = answere;
	}
}
