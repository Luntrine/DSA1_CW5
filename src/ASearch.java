import java.util.Arrays;

public class ASearch {


	private Entry[] catalogue;
	private int current;
	//All elements of catalogue without the nullValues;
	private Entry[] catalogueNoNull;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
	 */
	/**
	 * This method searches through a Entry array linearly (using a for loop) for an Entry with the 
	 * name equivalent to the one given in the method parameters. It then returns the number of
	 * the Entry whose name matched the parameter.
	 * 
	 * @param name that the method is searching through the list for.
	 * @return the number of the Entry whose name matched the parameter.
	 */
	public int linearSearch(String name){
		for(int i = 0; i < catalogue.length; i++) {
			//returns -1 if reaches part of array that is null.
			if(catalogue[i] == null) {
				return -1;
			}
			
			//returns number if search finds the number.
			if(catalogue[i].getName() == name) {
				return catalogue[i].getNumber();
			}
		}
		//returns -1 if reaches end of array.
		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	/**
	 * This method is an overloaded helper method to BinarySearch(String name).
	 * It searches through a Entry array binarily (using recursion) for an Entry with the 
	 * name equivalent to the one given in the method parameters. It then returns the number of
	 * the Entry whose name matched the parameter.
	 * 
	 * @param first is the first possible index the result could be in.
	 * @param last is the last possible index the result could be in.
	 * @param name that the method is searching through the list for.
	 * @return the number of the Entry whose name matched the parameter.
	 */
	private int binarySearch(int first,int last,String name){
		if(first>last) {
			return -1;
		}
		
		int middle = (first+last) / 2;
		
		int comparison = catalogue[middle].getName().compareTo(name);
		
		
		if(comparison == 0){ //If catalogue[middle].getName() is equal to name.
			return catalogue[middle].getNumber();
		}
		else if(comparison == -1) { //If catalogue[middle].getName() is less than name.
			return binarySearch(middle + 1, last, name);
		}
		else { //If catalogue[middle].getName() is greater than name.
			return binarySearch(first, middle - 1, name);
		}
	}
	
	/** 
	 * This method first finds out how many elements of catalogue are not null, and then
	 * returns the result of its helper method, which takes the name in its constructor
	 * as well as the indexes of the first and last non-null elements in the array as
	 * constructors for itself.
	 * 
	 * 
	 * @param name that the method is searching through the list for.
	 * @return the result of the helper method (the number of the Entry whose name matched the parameter).
	 */
	public int binarySearch(String name){
		int count = 0;
		while(catalogue[count] != null) //counts the number of non-null Entries in the Entry array.
		{
			count++;
		}
		return binarySearch(0, count, name);
	}
}
