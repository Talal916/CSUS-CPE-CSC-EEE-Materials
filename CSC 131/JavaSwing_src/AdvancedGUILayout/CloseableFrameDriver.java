package AdvancedGUILayout;

/**
 * A driver for the CloseableFrame class
 *
 */
public class CloseableFrameDriver
{
    /**
     * The entry point of the example
     */
    public static void main(String[] args)
    {
        CloseableFrame    f;

        f = new CloseableFrame();
        f.setSize(400, 400);
        f.setTitle("This Class is Great!");
        f.setVisible(true);
    }
}
