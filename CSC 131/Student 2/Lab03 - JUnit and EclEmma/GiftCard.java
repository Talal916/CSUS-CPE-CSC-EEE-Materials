/**
 * An encapsulation of a gift card that can be used to
 * make purchases at a retil store.
 */
public class GiftCard
{
    private static final int MAX_ID = 9999;    

    private double     balance;
    private int        issuingStore;
    

    /**
     * Explicit Value Constructor.
     *
     * @param storeID         The ID of the issuing store
     * @param openingBalance  The opening balance on the card
     * @throws IllegalArgumentException  If either parameter is "illegal"
     */
    public GiftCard(int storeID, double openingBalance) throws IllegalArgumentException
    {
        if (storeID < 0 || storeID > MAX_ID)
        {
            throw new IllegalArgumentException("Illegal Store ID: " + storeID);
        }
        else
        {
            issuingStore = storeID;            
        }
        

        if (openingBalance < 0.00)
        {
            throw new IllegalArgumentException("Illegal Balance: " + openingBalance);
        }
        else
        {
            balance = openingBalance;            
        }
    }

    /**
     * Deduct a (purchase) amount from this GiftCard.
     *
     * @param amount   The amount to deduct
     * @return         A message describing the result of the transaction
     */
    public String deduct(double amount)
    {
        String      result;
        
        if (amount < 0.0)
        {
            result = "Invalid Transaction";
        }
        else
        {
            balance -= amount;
            
            if (balance < 0.0)
            {
                result = "Amount Due: " + String.format("%6.2f",
                                                        Math.abs(balance));
                balance = 0.0;
            }
            else
            {
                result = "Remaining Balance: " + String.format("%6.2f",
                                                         Math.abs(balance));
            }
        }
        
        return result;
    }

    /**
     * Get the remaining balance on this GiftCard.
     *
     * @return  The balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Get the ID of the issuing store.
     *
     * @return  The ID
     */
    public int getIssuingStore()
    {
        return issuingStore;
    }
}
