/**
 *  Version: 1.0
 * 	Class: PatientMA
 * 	Description: PatientMA Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */
package naartjie;

public class PatientMA extends Patient 
{
		//Constants
		private static final long serialVersionUID = 1L;
		
		//Properties
		private String medicalAid;
		private int medicalNo;
		
		//remove contructor
		protected PatientMA(String title, String name, String address, String email, int telephone,
				String dOB, char gender, String allergies, boolean hasMedical, int age, String lastScriptDate,
				String medicalHistory, String prescriptions, String medicalAid, int medicalNo) 
		{
			super(title, name, address, email, telephone, dOB, gender, allergies, hasMedical, age, lastScriptDate,
					medicalHistory, prescriptions);
			this.medicalAid = medicalAid;
			this.medicalNo = medicalNo;
		}
		
		//Getters and Setters
		protected String getMedicalAid() {
			return medicalAid;
		}

		protected void setMedicalAid(String medicalAid) {
			this.medicalAid = medicalAid;
		}

		protected int getMedicalNo() {
			return medicalNo;
		}

		protected void setMedicalNo(int medicalNo) {
			this.medicalNo = medicalNo;
		}
}
