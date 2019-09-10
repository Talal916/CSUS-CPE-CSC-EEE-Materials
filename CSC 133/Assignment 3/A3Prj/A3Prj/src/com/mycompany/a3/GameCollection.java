package com.mycompany.a3;

import java.util.Vector;



public class GameCollection implements ICollection{

	private Vector<GameObject> gameObjs;

	public GameCollection()
	{
		gameObjs = new Vector<GameObject>();
	}
	
	@Override
	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjIterator();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return gameObjs.size();
	}

	@Override
	public void add(GameObject gameObj) {
			gameObjs.add(gameObj);
	}

	public void remove(GameObject toRemove) {
		// TODO Auto-generated method stub
		gameObjs.remove(toRemove);		
	}
	
	public GameObject getObjAt(int objIndex)
	{
		return gameObjs.get(objIndex);
		
	}
	
	private class GameObjIterator implements IIterator
	{
		private int index;
		
		public GameObjIterator()
		{
			index = -1;
		}

		@Override
		public boolean hasNext() {
			if(gameObjs.size() <= 0)
				return false;
			if(index == gameObjs.size() - 1)
			{
				index = -1;
				return false;
			}
			return true;
		}

		@Override
		public GameObject getNext() {
			index++;
			return gameObjs.get(index);
		}

	
		@Override
		public void remove(GameObject gameObj) {
			gameObjs.remove(gameObj);
			index--;
		}
	}



}
