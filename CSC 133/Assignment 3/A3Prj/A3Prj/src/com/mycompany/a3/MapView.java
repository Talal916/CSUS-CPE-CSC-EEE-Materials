package com.mycompany.a3;

import java.util.Observable;  
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;


public class MapView extends Container implements Observer{

	TextArea gameText;
	private IGameWorld prox;
	private int px;
	private int py;
	
	public MapView()
	{
		this.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.GREEN));
		this.setLayout(new BorderLayout());

		this.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.getAllStyles().setBgTransparency(255);
		
		
		
	}
	
	@Override
	public void update(Observable observable, Object data) {
		 prox = (IGameWorld) data;
		repaint();
		
		
	}
	
	public double getMapWidth()
	{
		double retval = (double) this.getWidth();
		
		return retval;
	}
	
	public double getMapHeight()
	{
		double retval = (double) this.getHeight();
	
		return retval;
		
		
	}

	

@Override
public void paint(Graphics graf)
{
	super.paint(graf);
	
	Point pCmpRelPrnt = new Point(this.getX(), this.getY());
	IIterator iterator = prox.getCollection().getIterator();
	
	while (iterator.hasNext())
	{
		GameObject curObject = iterator.getNext();
		if (curObject instanceof IDrawable)
		{

			((IDrawable) curObject).draw(graf, pCmpRelPrnt);
		}
	}
}


@Override
public void pointerPressed(int x, int y)
{
	px = x - getParent().getAbsoluteX();
	py = y - getParent().getAbsoluteY();
	
	Point pPtrRelPrnt = new Point(px, py);
	Point pCmpRelPrnt = new Point(getX(), getY());
	
	IIterator iterator = prox.getCollection().getIterator();
	
	while (iterator.hasNext())
	{
		GameObject curObj = iterator.getNext();
		if (curObj instanceof ISelectable)
		{
			ISelectable selectObj = (ISelectable)curObj;
			
			if (selectObj.contains(pPtrRelPrnt, pCmpRelPrnt))
			{
				selectObj.setSelected(true);
			}
			else
			{
				selectObj.setSelected(false);
			}
		}
	}
	repaint();
	System.out.println("Pressed");
}





}

