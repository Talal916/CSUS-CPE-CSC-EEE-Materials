% Engr 17
% Complex_Number_Matrix based script for a 2 x 2 matrix 
% A 2x2 matrix means you are solving two equations with two unknowns
% Written by Russ Tatro
% April 14, 2015
% clear the workspace and remove any "lingering" variables
clear all
clc
% State the knowns - each problem with have different unknowns
% But a 2x2 matrix has the fixed coefficients A11, A12, A21, A22 
% and C11,C21
% Enter the matrices in standard form of A*B=C
% Set up a 2 x 2 matrix
% first row of the matrix
A11 = 1;  %enter the number for each coefficient
A12 = 1;
C11 = 1;
% second row of the matrix
A21 = 2;
A22 = 2;
C21 = 2;
% Name the "to be solved for" variables (if you wish to) as you set them up  in your
% equations.
B11 = 'Var_1';
B21 = 'Var_2';
A = [A11 A12; A21 A22];
C = [C11; C21];
% The solution is B=A(inverse)*C
% Find the solution to the linear equations
B = inv(A)*C;
% now format the first variable found
B1_real = real(B(1));
B1_imag = imag(B(1));
[ThetaR1, Rho1] = cart2pol(B1_real,B1_imag);
ThetaD1 = ThetaR1/pi*180;
format_string = '\nRectangular %s = %.3f + j %.3f \n';
fprintf(format_string,B11,B1_real,B1_imag)
format_string = 'Polar %s = %.3f  Angle %.2f Degrees \n ';
fprintf(format_string,B11,Rho1,ThetaD1)
% now format the second variable found
B2_real = real(B(2));
B2_imag = imag(B(2));
[ThetaR2, Rho2] = cart2pol(B2_real,B2_imag);
ThetaD2 = ThetaR2/pi*180;
format_string = '\nRectangular %s = %.3f + j %.3f \n';
fprintf(format_string,B21,B2_real,B2_imag)
format_string = 'Polar %s = %.3f  Angle %.2f Degrees \n';
fprintf(format_string,B21,Rho2,ThetaD2)
% End of the script
