import java.util.Date;

/**
 * An encapsulation of a pre-paid fixed-rate phone card.
 *
 * This particular implementation has a limit on the number of
 * calls that can be made as well as on the total dollar value.
 */
public class PhoneCard
{
  private static final double MINUTES_PER_MILLISECOND = 1. / (1000.*60.);

  private Date[]     callEnds, callStarts;
  private double     balance; // In dollars
  private double     rate;    // In dollars per millisecond
  private int        calls, maxCalls;    
  private String[]   callNumbers;


  /**
   * Explicit Value Constructor.
   *
   * @param initialBalance   The initial balance (in dollars)
   * @param maxCalls         The number of calls that can be made
   * @param dollarsPerMinute The rate (in dollars per minute)
   */
  public PhoneCard(double initialBalance, int maxCalls, double dollarsPerMinute)       
  {
    calls         = 0;
    balance       = initialBalance;
    callStarts    = new Date[maxCalls];
    callEnds      = new Date[maxCalls];
    callNumbers   = new String[maxCalls];
    this.maxCalls = maxCalls;       

    rate          = dollarsPerMinute * MINUTES_PER_MILLISECOND;       
  }

  /**
   * End a call.
   * 
   * @param end    The ending date/time of the call
   */
  public void endCall(Date end)
  {
    double    cost;       
    long      length;


    callEnds[calls]  = end;       

    length   = callEnds[calls].getTime() - callStarts[calls].getTime();
    cost     = length * rate;    

    balance -= cost;

    ++calls;       
  }

  /**
   * Get the length of the longest call that can be
   * made using this card (based on the rate and the balance).
   *
   * @return  The length of the longest call (in milliseconds)
   */
  public long getAvailableMilliseconds()
  {
    long       available;

    available = 0;
    if (calls < maxCalls)
    {
      available  = (long)(balance / rate);
    }

    return available;
  }

  /**
   * Start a call.
   * 
   * @param number   The number that was called
   * @param start    The starting date/time of the call
   */
  public void startCall(String number, Date start)
  {
    callNumbers[calls] = number;
    callStarts[calls]  = start;       
  }
}

