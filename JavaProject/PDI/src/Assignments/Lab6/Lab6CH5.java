/*Challenge 5: Protected vs Private — “Hospital Patient Records”
Goal: Understand inheritance access levels.
Instructions:
• Base: PatientRecord
o private: _ssn
o protected: _medical_history
• Derived:
o OutpatientRecord
o InpatientRecord
Task:
Show which attributes are accessible and which are not in subclasses. */
public class Lab6CH5 {
    public static void main(String[] args) {
    }
    public static abstract class PatientRecord {
        private String _ssn;
        protected String _medical_history;

        public PatientRecord(String ssn, String medical_history) {
            this._ssn = ssn;
            this._medical_history = medical_history;
        }

        public String getSSN() {
            return _ssn;
        }
    }
    public static class OutpatientRecord extends PatientRecord {
        public OutpatientRecord(String ssn, String medical_history) {
            super(ssn, medical_history);
        }

        public void displayInfo() {

            System.out.println("Medical History: " + _medical_history); 
        }
    }
    public static class InpatientRecord extends PatientRecord {
        public InpatientRecord(String ssn, String medical_history) {
            super(ssn, medical_history);
        }

        public void displayInfo() {

            System.out.println("Medical History: " + _medical_history); 
        }
    }

}
