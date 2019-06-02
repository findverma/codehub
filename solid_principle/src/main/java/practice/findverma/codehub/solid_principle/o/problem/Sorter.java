package practice.findverma.codehub.solid_principle.o.problem;

import java.util.List;

public abstract class Sorter {
	public SortType sortType;
	public abstract void sort(List<String> collection);
}
