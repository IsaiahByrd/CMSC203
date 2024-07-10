/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents a plot for a property
 * Due: 07/08/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/

public class Plot {

	//fields
	
	private int x; //x-coordinate of the plot
	private int y; //y-coordinate of the plot
	private int width; //width of the plot
	private int depth; // depth of the plot 
	
	//default constructor
	public Plot() {
		width = 1;
		depth = 1;
	}
	
	//constructor that creates a plot using the given values
	public Plot(int x, int y, int width, int depth) {
		 
	    this.x = x;
	    this.y = y;
	    this.width = width;
	    this.depth = depth;
	}
	
	//constructor that creates a new plot given another plot
	public Plot(Plot otherPlot) {
		
		this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
	
	}
	

	//methods
	
	public boolean overlaps(Plot plot) {
		
		boolean xOverlap = false;
		boolean yOverlap = false;
		
		//check horizontal overlap
		if ((x < plot.x + plot.width) && (x + width > plot.x)) {
            xOverlap = true;
        }
		
		//check vertical overlap
		if ((y < plot.y + plot.depth) && (y + depth > plot.y)) {
	            yOverlap = true;
	    }
		
		//check if there is both horizontal and vertical overlap
		if (xOverlap && yOverlap) {
            return true;
        } else {
            return false;
        }
	}
	

	public boolean encompasses(Plot plot) { //determines if given plot is encompassed by this plot
        
        boolean xWithinBounds = false;
        boolean yWithinBounds = false;
        
        //checks if x-coordinate is within range
        if ((plot.x >= x) && (plot.x + plot.width <= x + width)) {
            xWithinBounds = true;
        }

        //checks if y-coordinate is within range
        if ((plot.y >= y) && (plot.y + plot.depth <= y + depth)) {
            yWithinBounds = true;
        }

        //checks if both the x and y coordinates are within bounds
        if (xWithinBounds && yWithinBounds) {
            return true;
        } 
        else {
            return false;
        }
    }
	
	//setters
	public void setX(int x) {
        this.x = x;
    }
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//getters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	//toString method
	@Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
