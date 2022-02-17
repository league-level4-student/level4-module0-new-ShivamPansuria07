package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */
	public void setItemsReceived(int randomPositiveNum) {

		
	}
     private int itemsReceived;
     // Getter
     public int getItems() {
       return itemsReceived;
     }

     // Setter
     public void setItems(int newItem) {
    if(this.itemsReceived<0) {
    	itemsReceived = 0;
    }else {
    	this.itemsReceived = newItem;
    }
    		
    
    }
     

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

    private double degreesTurned;
    // Getter
    public double getDegrees() {
      return degreesTurned;
    }

    // Setter
    public void setDegrees(double newDegree) {
    	if(this.degreesTurned>=0 && this.degreesTurned<=360.0) {
    		this.degreesTurned = newDegree;
    	}
//    	else {
//    		this.itemsReceived;
//    	}
      
    }

    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;
    public String getNomen() {
        return nomenclature;
      }

      // Setter
      public void setNomen(String newNomen) {
    	  if(this.nomenclature == "") {
    		  this.nomenclature = " ";
    		  //newNomen = " ";
    	  }
       
      }
    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;
    public Object getMember() {
        return memberObj;
      }

      // Setter
      public void setMember(Object newMember) {
        this.memberObj = newMember;
        
      }

	public Integer getItemsReceived() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
