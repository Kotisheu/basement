/*======================================
  class InsertionSort -- implements InsertionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class InsertionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) {

	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSortV, O(n*n)


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) {
	//declare and initialize empty ArrayList for copying
	ArrayList<Comparable> data = new ArrayList<Comparable>();

	//copy input ArrayList into working ArrayList
	for( Comparable o : input )
	    data.add( o );

	//sort working ArrayList
	insertionSortV( data );

	//return working ArrayList
	return data;
    }//end insertionSort, O(n*n)


    public static void main( String [] args ) {

	/*===============for VOID methods=============
	System.out.println("\n*** Testing sort-in-place (void) version... *** ");
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "\nArrayList glen before sorting:\n" + glen );
	insertionSortV(glen);
	System.out.println( "\nArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco );
	insertionSortV(coco);
	System.out.println( "\nArrayList coco after sorting:\n" + coco );
	  ============================================*/

	/*==========for AL-returning methods==========
	System.out.println( "*** Testing non-void version... *** " );
    	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "\nArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = insertionSort( glen );
	System.out.println( "\nsorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "\nArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = insertionSort( coco );
	System.out.println( "\nsorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "\nArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	  ============================================*/

    }//end main

}//end class InsertionSort
