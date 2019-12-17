% Engr 17
% Complex_Number_Matrix based script for direct entry of the matrix
% No training wheels in this script
% Written by Russ Tatro
% October 13, 2015
% clear the workspace and remove any "lingering" variables
clear all
clc
% Enter the A matrix row; new row; new row...
A = [0 3 -3 1; 7 -2 -5 0; -2 19 -3 3; -5 -3 9 0];
% Enter the C matrix of the correct numbe of columns
C = [0; 15; 0; 10];
% Find the solution to the linear equations
B = inv(A)*C
% You have to know the output order of the inputted variables
% End of the script
