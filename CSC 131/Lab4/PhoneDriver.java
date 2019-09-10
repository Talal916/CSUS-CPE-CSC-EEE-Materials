import java.util.Date;

/**
 * An application that uses the PhoneCard class.
 *
 */
public class PhoneDriver
{
  /**
   * The entry point of the application.
   *
   * @param args  The command-line arguments
   */
  public static void main(String[] args)
  {
    Date             end, now, start;       
    long             availableMillis;       
    PhoneCard        card;

    now   = new Date();
    card  = new PhoneCard(10.00, 2, 0.10);
    start = new Date(now.getTime());       
    end   = new Date(start.getTime() + 600000);

    
    // Get the status of the card
    availableMillis = card.getAvailableMilliseconds();       
    // Make a call if possible
    if (availableMillis > 0)
    {
      card.startCall("540-568-1671", start);
      card.endCall(end);
    }


    // Get the status of the card
    availableMillis = card.getAvailableMilliseconds();       
    // Make a call if possible
    if (availableMillis > 0)
    {
      start = new Date(end.getTime() + 1200000);       
      card.startCall("540-568-1667", start);
      end   = new Date(start.getTime() + 2400000);
      card.endCall(end);
    }


    // Get the status of the card
    availableMillis = card.getAvailableMilliseconds();       
    // Make a call if possible
    if (availableMillis > 0)
    {
      start = new Date(end.getTime() + 60000);       
      card.startCall("540-568-8771", start);
      end   = new Date(start.getTime() + 90000);
      card.endCall(end);
    }
  }
}
