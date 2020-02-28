/**
 * Colin Weinstein
 * CSE 360 - Assignment 1
 * SimpleList.java
 * February 10, 2020
 */

package cse360assign2;

/**
 * @author Colin Weinstein
 * SimpleList.java creates empty list of 10 ints with count initialized to 0.
 * Methods: add, remove, count, search, toString
 */
public class SimpleList {
	private int[] list;
	private int count;
	
	/**
	 * creates empty list of size 10
	 */
	SimpleList() {
		// creates new list and sets list = newList
		list = new int[10];
		count = 0;
	}
	
	
	/**
	 * add(int input) adds input to index 0 of list
	 */
	void add (int intToAdd) {
		if (count == 0)
			list[0] = intToAdd;	// add int at index 0 if list is empty
		else {
			// creates new list and adds new int to head if list is not empty
			int[] newList = new int[10];
			newList[0] = intToAdd;
			
			// adds up to first 9 existing ints in list to new list
			int iterator = 0;
			while (iterator < count && iterator < 9) {
				newList[iterator + 1] = list[iterator];
				iterator++;
			}
			
			list = newList;	// sets list equal to the newly created list
		} // ends else if (count != 0)
		if (count < 10)
			count++;	// if count is 0-9, increase count by one (max count = 10)
	} // end of add
	
	
	/**
	 * remove(int input) method removes input if found in list
	 */
	void remove (int intToRemove) {
		int index = search(intToRemove);
		if (index != -1) { // int not found if search returns -1
			int countToRemove = 0;
			if (index == 9) {
				// if int to remove is found to be last int in list
				list[9] = 0;
				countToRemove = 1;
			}
			else {
				// creates new list to remove all instances of number
				int[] newList = new int[10];
				int newPlace = 0;
				for (int iterator = 0; iterator < count; iterator++) {
					if (list[iterator] != intToRemove) {
						// if current number in list is not number to remove, 
						// add to new List in current place in new list and increase newPlace by one
						newList[newPlace] = list[iterator];
						newPlace++;
					}
					else
						countToRemove++;	// if current member in list == number to remove, 
											// do not add to new list and add one to count to remove
				}
				list = newList;				// sets list equal to new list
			} // end else if (index != 9)
			count -= countToRemove;	// reduces count by determined count
		} // end if (index != -1)
	}
	
	
	/**
	 * count() method returns count of current list
	 */
	int count () {
		return count;
	} // end of count
	
	
	/**
	 * toString() overloads default toString() method
	 * - outputs contents of list and count
	 */
	public String toString () {
		String outString = "";
		for (int iterator = 0; iterator < count - 1; iterator++) {
			outString = outString + list[iterator] + " ";
		}
		outString = outString + list[count - 1] + "\nCount: " + count + "\n";
		return outString;
	} // end of toString
	
	
	/**
	 * search(int input) method returns index of input if found in list
	 * - if input is not found, search returns -1
	 */
	int search (int intToFind) {		
		int iterator = 0;
		int index = -1;
		// searches until end of list or until int is found in list
		while (iterator < count && list[iterator] != intToFind) {
			iterator++;
		}
		if (list[iterator] == intToFind)
			index = iterator;	// sets index = iterator if found
		return index;			// returns index found or -1 if not found
	}
}

