/**
 *  Version: 1.0
 * 	Class: Drug
 * 	Description: Drug Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

public class Drug 
{
	//Properties
	private String drugId;
	private String drugName;
	private String drugDescription;
	private int numberOfDrugs;

	//Getters and Setters
	protected String getDrugId() 
	{
		return drugId;
	}
	protected void setDrugId(String drugId) 
	{
		this.drugId = drugId;
	}
	protected String getDrugName() 
	{
		return drugName;
	}
	protected void setDrugName(String drugName) 
	{
		this.drugName = drugName;
	}
	protected String getDrugDescription() 
	{
		return drugDescription;
	}
	protected void setDrugDescription(String drugDescription) 
	{
		this.drugDescription = drugDescription;
	}
	
	protected int getNumberOfDrugs() 
	{
		return numberOfDrugs;
	}
	protected void setNumberOfDrugs(int numberOfDrugs) 
	{
		this.numberOfDrugs = numberOfDrugs;
	}
	

}
