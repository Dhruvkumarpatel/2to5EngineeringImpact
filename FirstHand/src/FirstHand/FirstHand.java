package FirstHand;

/**
 * cerner_2^5_2017
 * {@link FirstHand} is used to identify valid funding criteria for child funding request application.
 * 
 * @author Dhruv Patel
 */
public class FirstHand
{
    /**
     * Assume Child Class is already present with getAge(), isMentalState(), getRequest() method and all details.
     * Assume Request class is present to represent Application details and isRelatedToHealth(), isInsuredByOtherCoverage() methods.
     * 
     * @param childDetails {@link Child}
     * @return true if valid criteria otherwise return false.
     */
    public boolean checkValidFundingCriteria(final Child childDetails)
    {
        // Child must be 18 years of age or younger.
        if (!(childDetails.getAge() <= 18))
        {
            return false;
        }
        // a person 19–21 may be considered if they are in a child-like mental state).
        else if (childDetails.isMentalState())
        {
            if (!(childDetails.getAge() <= 21 && childDetails.getAge() >= 19))
            {
                return false;
            }
        }
        // The request must be clinically relevant to the health of the child.
        else if (!childDetails.getRequest().isRelatedToHealth())
        {
            return false;
        }
        // There must be no existing insurance coverage for the requested expenses.
        else if (childDetails.getRequest().isInsuredByOtherCoverage())
        {
            return false;
        }
        return true;
    }
}
