import tkinter as tk
from tkinter import filedialog
import pandas as pd
global data
data = pd.read_csv('C:\\Users\\Talal\\School\\CSC 177\\Labs\\Lab 1\\Missing Values\\LaqnData.csv')
data.columns = ['Site','Species','ReadingDateTime','Value','Units','Provisional or Ratified']

print('Number of instances = %d' % (data.shape[0]))
print('Number of attributes = %d' % (data.shape[1]))
data=data.drop(['Provisional or Ratified'],axis = 1)

#dropping all rows that contain missing values
data = data.dropna(axis='rows')


data.head()

root= tk.Tk()

canvas1 = tk.Canvas(root, width = 300, height = 300, bg = 'lightsteelblue2', relief = 'raised')
canvas1.pack()

def saveCSV():
	exportPath = filedialog.asksaveasfilename(defaultextension ='.csv')
	data.to_csv(exportPath, index = None, header=True)
	    
saveAsButton_CSV = tk.Button(text='Export CSV', command=saveCSV)
canvas1.create_window(150, 150, window=saveAsButton_CSV)

root.mainloop()