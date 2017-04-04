package lab0;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException if the validation fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    public int MaxVacationDays = 28;
    public int MinVacationDays = 0;
    private String firstName;
    private String lastName;
    private String ssn;
    private int daysVacation;

    public Employee() {
        // initialize a bunch of default values
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        daysVacation = 0;
    }

    /**
     * Convenience constructor to set all properties.
     *
     * @param firstName - cannot be null or empty
     * @param lastName - cannot be null or empty
     * @param ssn
     * @param daysVacation
     * @throws IllegalArgumentException if parameters are not valid
     */
    public Employee(String firstName, String lastName, String ssn, int daysVacation) throws MandatoryStringException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setDaysVacation(daysVacation);
    }

    public final int getDaysVacation() {
        return daysVacation;
    }

    public final void setDaysVacation(int daysVacation) throws MandatoryStringException {
        if (daysVacation > MinVacationDays || daysVacation < MaxVacationDays) {
            this.daysVacation = daysVacation;
        }
        throw new MandatoryStringException("Sorry,Vacation days cannot be less than " + MinVacationDays + " or grater than " + MaxVacationDays + ". Please try again");
    }

    public final String getFirstName() {
        return firstName;
    }

    /**
     * Mutates the first name.
     *
     * @param firstName - cannot be null or empty
     * @throws IllegalArgumentException if firstName is null or empty
     */
    public final void setFirstName(String firstName) throws MandatoryStringException {
        if (firstName == null || firstName.isEmpty()) {
            throw new MandatoryStringException("Sorry, first name is mandatory. Please try again");
        }
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    /**
     * Mutates the lastName.
     *
     * @param lastName - cannot be null or empty
     * @throws IllegalArgumentException if lastName is null or empty
     */
    public final void setLastName(String lastName) throws MandatoryStringException {
        if (lastName == null || lastName.isEmpty()) {
            throw new MandatoryStringException("Sorry, last name is mandatory. Please try again");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn) throws MandatoryStringException {
        if (!(ssn == null || ssn.isEmpty())) {
            if (ssn.length() == 9 || ssn.length() == 11) {
                if (ssn.length() == 9) {
                    try {
                        Integer.parseInt(ssn);
                        this.ssn = ssn;
                    } catch (NumberFormatException ne) {
                        throw new NumberFormatException("SSN should contain only whole numbers");
                    }
                } else {
                    try {
                        String[] ssnParts = ssn.split("-");
                        if (ssnParts.length == 3) {
                            if (ssnParts[0].length() == 3 && ssnParts[1].length() == 2 && ssnParts[2].length() == 4) {
                                for (int s = 0; s < ssnParts.length; s++) {
                                    Integer.parseInt(ssnParts[s]);
                                }
                                this.ssn = ssn;
                            }
                        }
                    } catch (NumberFormatException ne) {
                        throw new NumberFormatException("SSN should contain only whole numbers");
                    }
                }
            }
        } else {
            throw new MandatoryStringException("Sorry, SSN is mandatory. Please try again");
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
