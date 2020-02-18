/*CSC139
Fall 2018
Fourth Assignment
Monreal, Diana
Section # 1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment4{
	
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test1.txt"); 
        Scanner scan = new Scanner(file);
        
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        
        int numPages = scan.nextInt(); 
        int numFrames = scan.nextInt();
        int numPageReq = scan.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>(numPageReq);
        while(scan.hasNextInt())    list.add(scan.nextInt());
             
        //Calling the Replacement Policies. 
        FIFO(list, numPages, numFrames, numPageReq);
        System.out.println();
        System.out.println();
        Optimal(list, numPages, numFrames, numPageReq);
        System.out.println();
        System.out.println();
        LRU(list, numPages, numFrames, numPageReq);
        
        scan.close();
        out.close();      
    }
    //FIFO Policy
    public static void FIFO(ArrayList<Integer> list, int numPages, int numFrames, int numPageReq) {
        System.out.println("FIFO");
        ArrayList<Integer> newFrames = new ArrayList<>(numFrames);

        int count = -1;
        int faults = 0;
        int frameIdx = 0;
        int curPage;
         
        while(++count != numPageReq) {
            curPage = list.get(count);
            if(frameIdx == numFrames) frameIdx = 0;//Reset the frame index.
            //Page is not already loaded.
            if(!newFrames.contains(curPage) && count <= numFrames) {
                newFrames.add(curPage);
                System.out.println("Page " + curPage + " loaded in Frame " + frameIdx);
                frameIdx++;
                faults++;
            }
            //Page is not already loaded and hasn't empty space.
            else if (!newFrames.contains(curPage) && count > numFrames) {
                System.out.println("Page " + newFrames.get(frameIdx) + " unloaded from Frame " + frameIdx + ", Page " + curPage + " loaded into Frame " + frameIdx);
                newFrames.set(frameIdx, curPage);
                frameIdx++;
                faults++;
            }
            //Page is already loaded.
            else    
                System.out.println("Page " + curPage + " already in Frame " + newFrames.indexOf(curPage));
        }
        System.out.println(faults + " page faults");
    }
    //end of FIFO    
    
    //LRU Policy
    public static void LRU(ArrayList<Integer> list, int numPages, int numFrames, int numPageReq) {
        System.out.println("LRU");

        ArrayList<Integer> newFrames    = new ArrayList<>(numFrames);
        ArrayList<Integer> frameFreq    = new ArrayList<>(numFrames);
        ArrayList<Integer> rangeArray   = new ArrayList<>();
        
        int count       = -1;
        int faults      =  0;
        int frameIdx    =  0;
        int curPage, minIdx;
        
        while(++count != numPageReq) {
            curPage = list.get(count);
            rangeArray.add(curPage);
            if(frameIdx == numFrames) frameIdx = 0;//Reset frame index.
            //Pafe is not loaded.
            if(!newFrames.contains(curPage) && count <= numFrames) {
                newFrames.add(curPage);
                System.out.println("Page " + curPage + " loaded into Frame " + frameIdx);
                frameIdx++;
                faults++;
            }
            //Page is not already loaded and hasn't empty space.
            else if (!newFrames.contains(curPage) && count > numFrames) {
                for(int frame : newFrames) frameFreq.add(rangeArray.lastIndexOf(frame));
                minIdx = frameFreq.indexOf(Collections.min(frameFreq));             
                System.out.println("Page " + newFrames.get(minIdx) + " unloaded from Frame " + minIdx + ", Page " + curPage + " loaded in Frame " + minIdx);
                newFrames.set(minIdx, curPage);
                frameFreq.clear();
                faults++;
            }
            //Page is already loaded.
            else    
                System.out.println("Page " + curPage + " already in Frame " + newFrames.indexOf(curPage));
        }
        System.out.println(faults + " page faults"); 
    }
    //End of LRU
    
    //Optimal Policy
    public static void Optimal(ArrayList<Integer> list, int numPages, int numFrames, int numPageReq) {
        System.out.println("Optimal");

        ArrayList<Integer> newFrames    = new ArrayList<>(numFrames);
        ArrayList<Integer> frameFreq    = new ArrayList<>(numFrames);
        ArrayList<Integer> rangeArray   = new ArrayList<>();

        int count       = -1;
        int faults      =  0;
        int frameIdx    =  0;
        int curPage,  minIdx;
        
        while(++count != numPageReq) {
            curPage = list.get(count);
            for(int i = count; i != numPageReq; i++)
              rangeArray.add(list.get(i));
            if(frameIdx == numFrames) frameIdx = 0;//Reset the frame index.
            //Page is not loaded.
            if(!newFrames.contains(curPage) && count <= numFrames) {
                newFrames.add(curPage);
                System.out.println("Page " + curPage + " loaded in Frame " + frameIdx);
                frameIdx++;
                faults++;
            }
            //Page is not already loaded and hasn't empty space.
            else if (!newFrames.contains(curPage) && count > numFrames) {
                for(int frame : newFrames) frameFreq.add(rangeArray.lastIndexOf(frame));
                minIdx = frameFreq.indexOf(Collections.min(frameFreq));             
                System.out.println("Page " + newFrames.get(minIdx) + " unloaded from Frame " + minIdx + ", Page " + curPage + " loaded into Frame " + minIdx);
                newFrames.set(minIdx, curPage);
                frameFreq.clear();
                faults++;
            }
            //Pafe is already loaded.
            else    
                System.out.println("Page " + curPage + " already in Frame " + newFrames.indexOf(curPage));
            rangeArray.clear();
        }
        System.out.println(faults + " page faults");
    }//End of Optimal       
}
