// Tests the garbage collector: adds 100 elements to an empty linked list; then
// removes half of them (every other one); adds another 100 elements, and
// likewise removes half; iterates on this a number of times. In the steady
// state, the post-removal list-length will converge on 100.
// 
//  Correct output is:
//   99998 99996 99994 99992 99990 99988 99986 99984 99982 99980
//   99978 99976 99974 99972 99970 99968 99966 99964 99962 99960
//   99958 99956 99954 99952 99950 99948 99946 99944 99942 99940
//   99938 99936 99934 99932 99930 99928 99926 99924 99922 99920
//   99918 99916 99914 99912 99910 99908 99906 99904 99902 99900
//   99897 99893 99889 99885 99881 99877 99873 99869 99865 99861
//   99857 99853 99849 99845 99841 99837 99833 99829 99825 99821
//   99817 99813 99809 99805 99801 99794 99786 99778 99770 99762
//   99754 99746 99738 99730 99722 99714 99706 99697 99681 99665
//   99649 99633 99617 99601 99570 99538 99506 99449 99370 99170

// Main class
class Main {

    // the next counter we'll use in making a list element
    int count;

    public void main() {
	// create empty list
	IntList myList = null;

	// tells whether to remove first element of list (toggles
	// with each iteration)
	boolean removeFirst = false;

	// perform 1000 iterations of adding 100 elements to the front
	// of a list and removing every other element
	for (int i = 0; i < 1000; i++) {
	    myList = add100Elements(myList); // add
	    myList = removeAlternateElements(myList, removeFirst); // remove
	    removeFirst = !removeFirst; // toggle the "remove first" flag
	}

	// print the list
	myList.print();
    }
    
    // Adds 100 elements to the front of a list; values used are the next
    // 100 values, given by the 'count' instance variable. Returns the new
    // version of the list.
    public IntList add100Elements(IntList orig) {
	// our list
	IntList rtnVal = orig;

	// add the 100 elements
	for (int i = 0; i < 100; i++) {
	    rtnVal = new IntList().init(count, rtnVal);
	    count++; // bump count
	}

	// return the list
	return rtnVal;
    }
    
    // Removes every other elements from the list. The 'removeFirst' parameter
    // tells us whether to start by removing the first element (as opposed to
    // the second one).
    public IntList removeAlternateElements(IntList orig, boolean removeFirst) {
	// remove the first element, if specified
	if (removeFirst && orig != null) {
	    orig = orig.next;
	}

	// remove every other element
	for (IntList p = orig; p != null && p.next != null; p = p.next) {
	    p.next = p.next.next;
	}

	// return the new list
	return orig;
    }
    
}

// a linked list of integers
class IntList {
    int val; // data value
    IntList next; // next-pointer
    
    // "constructor"
    public IntList init(int num, IntList nextList) {
	val = num;
	next = nextList;
	return this;
    }
    
    // list-printing, 10 elements per line
    public void print() {
	// our Lib object, for printing
	Lib lib = new Lib();

	// elements printed on current line so far
	int elementsOnLine = 0;

	// the separator string, printed before the next element
	String sepString = "";

	// print each element, preceded by separator string; print newlines
	// when appropriate
	for (IntList p = this; p != null; p = p.next) {
	    // print separator string, followed by the value; also, increment
	    // the "elements printed on current lint" count, and set the
	    // separator string to " " in anticipation of another value
	    // on the same line
	    lib.printStr(sepString);
	    lib.printInt(p.val);
	    elementsOnLine++;
	    sepString = " ";

	    // if we've just printed our 10th element, emit a newline,
	    // set the separator string to the empty string, set our
	    // "elements printed on current line" count to 0
	    if (elementsOnLine >= 10) {
		lib.printStr("\n");
		sepString = "";
		elementsOnLine = 0;
	    }
	}

	// if there are elements remaining on the last line, print a newline
	// character
	if (elementsOnLine > 0) {
	    lib.printStr("\n");
	}
    }
}

