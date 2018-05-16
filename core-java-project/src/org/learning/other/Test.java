package org.learning.other;

/**
 * This class is like the one in the folder Comparable, but adds a constructor
 * and hashCode for testing purposes.
 */
public class Test {
	private String first; // first name
	private String last; // last name

	public Test() {
		this("", "");
	} // end default constructor

	public Test(String firstName) // for testing ***************
	{
		this(firstName, "");
	} // end constructor

	public Test(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	} // end constructor

	@Override
	public int hashCode() // for testing ***************
	{
		// this hash code causes collisions
		int h = 0;

		for (int i = 0; i < first.length(); i++) {
			h = h + first.charAt(i);
		}
		return h;
		// a reasonable hash code follows:
		// return first.hashCode() + last.hashCode();
	} // end hashCode

	public void setName(String firstName, String lastName) {
		setFirst(firstName);
		setLast(lastName);
	} // end setName

	public String getName() {
		return toString();
	} // end getName

	public void setFirst(String firstName) {
		first = firstName;
	} // end setFirst

	public String getFirst() {
		return first;
	} // end getFirst

	public void setLast(String lastName) {
		last = lastName;
	} // end setLast

	public String getLast() {
		return last;
	} // end getLast

	public void giveLastNameTo(Test aName) {
		aName.setLast(last);
	} // end giveLastNameTo

	@Override
	public String toString() {
		return first + " " + last;
	} // end toString

	@Override
	public boolean equals(Object other) {
		boolean result;

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			Test otherName = (Test) other;
			result = first.equals(otherName.first)
					&& last.equals(otherName.last);
		} // end if

		return result;
	} // end equals

} // end Name