package test;

public class Filter {
	private String filterName;// position or league or age
	private String filterValue;
	private int[] range; // 2位整数数组，将会用到Integer.MAX,MIN

	public Filter() {
		super();
		range = new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
		filterValue = "All";
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public int[] getRange() {
		return range;
	}

	public void setRange(int[] range) {
		this.range = range;
	}

}
