package test;

import java.util.ArrayList;

public class ParameterExplicate {
	private boolean isPlayer;// player or team

	private Mode mode = new Mode("all", null, false);// 可以不初始化
	private ArrayList<Filter> filterList = new ArrayList<Filter>(); // 可以不初始化
	private ArrayList<Sort> sortList = new ArrayList<Sort>();// 如果没有则为空，可以不初始化
	// 独立，可选
	private int number = 50;// 前多少条信息，默认最大
	private boolean isHigh = false;// 是否为高阶数据
	private boolean isAverage = true;// 是否为平均数，默认是
	
	public ParameterExplicate(String[] args) {
		// 采用从前往后理解的方式进行读取命令
		ArrayList<String> input=new ArrayList<String>();
		for(int i=0;i<args.length;i++){
			input.add(args[i]);
		}
		int debugTimes = 20;
		while (input.size() != 0) {
			debugTimes--;
			if (debugTimes == 0)
				break;

			switch (input.get(0)) {
			case "-player":
				this.setPlayer(true);
				input.remove(0);
				break;
			case "-team":
				this.setPlayer(false);
				input.remove(0);
				break;

			case "-avg":
				input.remove(0);
				break;
			case "-total":
				this.setAvarage(false);
				input.remove(0);
				break;

			case "-high":
				this.setHigh(true);
				input.remove(0);
				break;

			case "-n":
				int number = Integer.parseInt(input.get(1));
				this.setNumber(number);
				input.remove(1);
				input.remove(0);
				break;

			case "-all":
				input.remove(0);
				break;
			case "-hot":
				String field = input.get(1);
				Mode mode = new Mode();
				mode.setMode("hot");
				mode.setField(field);
				this.addSort(new Sort(field, false));
				this.setMode(mode);
				input.remove(1);
				input.remove(0);
				break;
			case "-king":
				String fieldKing = input.get(1);
				String during = input.get(2);
				Mode modeKing = new Mode();
				modeKing.setMode("king");
				modeKing.setField(fieldKing);
				this.addSort(new Sort(fieldKing, false));
				if (during.equals("-season")) {
					modeKing.setDaily(false);
				} else {
					modeKing.setDaily(true);
				}
				this.setMode(modeKing);
				input.remove(2);
				input.remove(1);
				input.remove(0);
				break;

			case "-filter":
				ArrayList<Filter> filterList = new ArrayList<Filter>();
				StringBuffer filterParameterBuffer = new StringBuffer("");
				String[] listFilter = null;
				int deleteNumber = 1; // 要删掉数据的数目
				// 将filter参数压缩成一个stringBuffer
				for (int i = 1; i < input.size(); i++) {
					if (input.get(i).contains("-")) {
						break;
					}

					else {
						filterParameterBuffer.append(input.get(i));
						deleteNumber++;
					}
				}

				// 将string解压成若干个string
				String filterParameter = filterParameterBuffer.toString();
				listFilter = filterParameter.split(",");

				for (String token : listFilter) {
					token = token.trim();
					String[] pair = token.split("\\.");
					Filter filter = new Filter();
					filter.setFilterName(pair[0]);
					if (filter.getFilterName().equals("age")) {
						// 处理此处为age的情况
						int[] range = new int[2];
						if (pair[1].equals("All")) {
							range[0] = Integer.MIN_VALUE;
							range[1] = Integer.MAX_VALUE;
						} else if (pair[1].contains("X")) {
							range[0] = Integer.parseInt(pair[1].split("<")[0]);
							range[1] = Integer.parseInt(pair[1].split("<=")[1]);
						} else if (pair[1].contains("<=")) {
							range[0] = Integer.MIN_VALUE;
							range[1] = Integer.parseInt(pair[1].split("<=")[1]);
						} else if (pair[1].contains(">")) {
							range[0] = Integer.parseInt(pair[1].split(">")[1]);
							range[1] = Integer.MAX_VALUE;
						} else {
							System.out.println("error in parse -filter: "
									+ pair[0] + " " + pair[1]);
						}

						filter.setRange(range);
					} else {
						filter.setFilterValue(pair[1]);
					}

					filterList.add(filter);
				}
				this.setFilterList(filterList);

				// remove,删掉deleteNumber个数据
				for (int i = deleteNumber; i >= 1; i--) {
					input.remove(0);
				}
				break;

			case "-sort":
				String[] listSort = input.get(1).split(",");
				for (String token : listSort) {
					String[] pair = token.split("\\.");
					Sort sort = new Sort();
					sort.setField(pair[0]);
					if (pair[1].equals("asc")) {
						sort.setAsc(true);
					} else {
						sort.setAsc(false);
					}
					this.addSort(sort);
				}
				input.remove(1);
				input.remove(0);
				break;

			default:
				System.out.println("BLParameter.constructor: " + input.get(0));
				break;
			}

		}

		// 如果sort并没有加任何东西，则对sort进行默认初始化
		if (this.sortList.size() == 0) {
			if (this.isPlayer) {
				if (!this.isHigh) {
					this.addSort(new Sort("point", false));
				} else {
					this.addSort(new Sort("realShot", false));
				}
			} else {
				if (!this.isHigh) {
					this.addSort(new Sort("point", false));
				} else {
					this.addSort(new Sort("winRate", false));
				}
			}
		}
	}

	public ParameterExplicate() {
		super();
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public ArrayList<Filter> getFilterList() {
		return filterList;
	}

	public void addFilter(Filter filter) {
		this.filterList.add(filter);
	}

	public void setFilterList(ArrayList<Filter> filterList) {
		this.filterList = filterList;
	}

	public void addSort(Sort sort) {
		this.sortList.add(sort);
	}

	public ArrayList<Sort> getSortList() {
		return sortList;
	}

	public void setSortList(ArrayList<Sort> sortList) {
		this.sortList = sortList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isHigh() {
		return isHigh;
	}

	public void setHigh(boolean isHigh) {
		this.isHigh = isHigh;
	}

	public boolean isAvarage() {
		return isAverage;
	}

	public void setAvarage(boolean isAvarage) {
		this.isAverage = isAvarage;
	}
}
