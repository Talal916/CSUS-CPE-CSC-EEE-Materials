/**
 * The main class for the CashMachine application
 */
public class CashMachine
{
    /**
     * The entry point of the application
     *
     * @param args   The command-line arguments
     */
    public static void main(String[] args)
    {
        PINPadWindow         window;
        
        window = new PINPadWindow();
        window.setTitle("ATM");        
        window.setVisible(true);
    }
}
