package test;

public class Mode {
	private String mode = "all"; // all or hot or king，默认all
	private String field; // score or rebound or assist
	private boolean isDaily; // season or daily

	public Mode() {
		super();
	}

	public Mode(String mode, String field, boolean isDaily) {
		super();
		this.mode = mode;
		this.field = field;
		this.isDaily = isDaily;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isDaily() {
		return isDaily;
	}

	public void setDaily(boolean isDaily) {
		this.isDaily = isDaily;
	}

}
