package test;

public class Sort {
	private String field;
	private boolean isAsc;// 是否升序

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	public Sort(String field, boolean isAsc) {
		super();
		this.field = field;
		this.isAsc = isAsc;
	}

	public Sort() {
		super();
	}

}