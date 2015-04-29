// correct output:
// [3 4]
// [21]
// [-4 27]
// [101 Charlie]
// [34]
// 
// [34]
// [101 Charlie]
// [-4 27]
// [21]
// [3 4]

// Main class
class Main {
    // main method
    public void main() {
	Lib lib = new Lib(); // lib object, for I/O

	// create list with four elements; some have one data item, and
	// some (through inheritance) have two data items
	List list = null;
	list = new List().init(34,list);
	list = new List2a().init2a(101, "Charlie", list);
	list = new List2().init2(-4, 27, list);
	list = new List().init(21, list);
	list = new List2().init2(3, 4, list);

	// print the list; the print in reverse order
	list.print(lib);
	lib.printStr("\n");
	list.reversePrint(lib);
    }
}

// List class: a linked list of int
class List {
    int val; // data value
    List next; // next-pointer

    // "constructor", which initializes the instance variables from
    // its parameters
    public List init(int num, List next) {
	val = num;
	this.next = next;
	return this;
    }

    // a string containing the data values of the object
    public String valString() {
	Lib lib = new Lib();
	return lib.intToString(val);
    }

    // a *bracketed* string containing the data values of the object
    public String valStringBracketed() {
	return "[".concat(valString().concat("]"));
    }

    // prints list elements in forward order
    public void print(Lib lib) {
	// print first element
	lib.printStr(valStringBracketed());

	// print remaining elements in forward order
	lib.printStr("\n");
	if (next != null) {
	    next.print(lib);
	}
    }

    // prints list elements in reverse order
    public void reversePrint(Lib lib) {
	// print remaining elements in reverse order
	if (next != null) {
	    next.reversePrint(lib);
	}
	// print first element
	lib.printStr(valStringBracketed());
	lib.printStr("\n");
    }
}

// List2 class: a linked list of int-pairs
class List2 extends List {
    int val2; // the second data item (note: first is inherited)

    // "constructor", which initializes the instance variables from
    // its parameters
    public List init2(int num, int num2, List next) {
	val2 = num2;
	return super.init(num, next);
    }

    // a string containing the data values of the object
    public String valString() {
	Lib lib = new Lib();
	return super.valString().concat(" ".concat(lib.intToString(val2)));
    }
}

// List2a class: a linked list of int/String pairs
class List2a extends List {
    String val2; // the second data item (note: first is inherited)

    // "constructor", which initializes the instance variables from
    // its parameters
    public List init2a(int num, String str, List next) {
	val2 = str;
	return super.init(num, next);
    }

    // a string containing the data values of the object
    public String valString() {
	Lib lib = new Lib();
	return super.valString().concat(" ".concat(val2));
    }
}
