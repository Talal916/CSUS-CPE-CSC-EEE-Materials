package com.mycompany.eventprog;

import com.codename1.ui.Container;

public class PointerContainer extends Container{
	  @Override
	  public void pointerPressed(int x,int y){
	    System.out.println("Pointer PRESSED x and y: " + x + " " + y);	}
	  @Override
	  public void pointerReleased(int x,int y){
	    System.out.println("Pointer RELEASED x and y: " + x + " " + y);	}
	  @Override
	   public void pointerDragged(int x,int y){
	     System.out.println("Pointer DRAGGED x and y: " + x + " " + y);	}
	}
