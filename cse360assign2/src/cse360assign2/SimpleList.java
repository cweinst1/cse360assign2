/**
 * Colin Weinstein
 * CSE 360 - Assignment 1
 * SimpleList.java
 * February 10, 2020
 */
package cse360assign2;

public class SimpleList {
	private int[] list;
	private int count;
	
	/**
	 * creates empty list of size 10
	 */
	SimpleList() {
		// creates new list and sets list = newList
		int[] list = new int[10];
		count = 0;
	}
	
	
	/**
	 * add(int input) adds input to index 0 of list
	 */
	void add (int intToAdd) {
		if (count == 0)
			list[0] = intToAdd;	// add int at index 0 if list is empty
		else if (count < list.length) {
			// creates new list and adds new int to head if list is not empty
			int[] newList = new int[10];
			newList[0] = intToAdd;
			
			// adds first 9 existing ints in list to new list
			int iterator = 0;
			while (iterator < count && iterator < 9) {
				newList[iterator + 1] = list[iterator];
				iterator++;
			}
			
			list = newList;	// sets list equal to the newly created list
		} // ends else if (count != 0)
		else if (count == list.length) {
			int[] newList = new int[(int) (count * 1.5)];
			newList[0] = intToAdd;
			
			// adds existing ints
			for (int iterator = 0; iterator < count; iterator++)
				newList[iterator + 1] = list[iterator];
			
			list = newList; // sets list equal to newly created list of 150% length
		}
		count++;
	} // end of add
	
	
	/**
	 * append(int input) method adds new input to end of list
	 */
	void append(int intToAppend) {
		if (count < list.length)
			list[count] = intToAppend;	// add int at index 0 if list is empty
		else if (count == list.length) {
			int[] newList = new int[(int) (count * 1.5)];
			// adds existing ints
			for (int iterator = 0; iterator < count; iterator++)
				newList[iterator] = list[iterator];
			// appends new int
			newList[count] = intToAppend;
			
			list = newList; // sets list equal to newly created list of 150% length
		}
		count++;
	} // end of append
	
	
	/**
	 * remove(int input) method removes input if found in list
	 */
	void remove (int intToRemove) {
		int index = search(intToRemove);
		if (index != -1) { // int not found if search returns -1
			if (index == 9)
				list[9] = 0;
			else if (count > .75 * list.length) {
				// iterator to store index of value to be shifted
				for (int iterator = index + 1; iterator < count; iterator++) {
					// shifts left one value, shifting in 0
					list[iterator - 1] = list[iterator];
					list[iterator] = 0;
				} // ends while (iterator < count)
			} // end else if count > .75 * list.lenght
			else if (count < .75 * list.length) {
				if (list.length != 1) {
					int[] newList = new int[(int) (count * .75)];
					for (int iterator = 0; iterator < index; iterator++)
						newList[iterator] = list[iterator];
					for (int iterator = index + 1; iterator < count; iterator++)
						newList[iterator - 1] = list[iterator];
					list = newList;
				}
			}
			count--;	// reduces count by one
		} // end if (index != -1)
	} // end of remove
	
	
	/**
	 * count() method returns current list count
	 */
	int count () {
		return count;
	} // end of count
	
	
	/**
	 * first() method returns first element in the list, or -1 if there are no elements
	 */
	int first() {
		int ret = -1;
		if (count != 0)
			ret = list[0];
		return ret;
	} // end of first
	
	
	/**
	 * last() method returns last element in the list, or -1 if there are no elements
	 */
	int last() {
		int ret = -1;
		if (count != 0)
			ret = list[count - 1];
		return ret;
	} // end of last
	
	
	/**
	 * size() method returns current number of possible locations in the list
	 */
	int size() {
		return list.length;
	} // end of size
	
	
	/**
	 * search(int input) method returns index of input if found in list
	 * - if input is not found, search returns -1
	 */
	int search (int intToFind) {		
		int iterator = 0;
		int index = -1;
		while (iterator < count && list[iterator] != intToFind) {
			iterator++;
		}
		if (list[iterator] == intToFind)
			index = iterator;	// sets index = iterator if found
		return index;			// returns index found or -1 if not found
	} // end of search
	
	
	/**
	 * toString() overloads default toString() method
	 * - outputs contents of list and count
	 */
	public String toString () {
		String outString = "";
		for (int iterator = 0; iterator < count; iterator++) {
			outString = outString + list[iterator] + " ";
		}
		outString = outString + "\nCount: " + count + "\n";
		return outString;
	} // end of toString

}

