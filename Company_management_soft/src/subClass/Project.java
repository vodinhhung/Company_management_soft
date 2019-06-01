package subClass;

public class Project {
    
    int PrID;
    String PrName, Link;
    
    public void setPrID(int PrID) {
	        this.PrID = PrID;
	    }
	 
    public void setPrName(String PrName) {
	        this.PrName = PrName;
	    }
	 
    public int getPrID() {
	        return PrID;
	    }
	 
    public String getPrName() {
	        return PrName;
	    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getLink() {
        return Link;
    }
    
}
