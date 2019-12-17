% Engr 17
% Complex_Number_Matrix based script for a 3 x 3 matrix 
% A 3x3 matrix means you are solving three equations with three unknowns
% Written by Russ Tatro
% April 14, 2015
% clear the workspace and remove any "lingering" variables
clear all
clc
% State the knowns - each problem with have different unknowns
% Enter the matrices in standard form of A*B=C
% Set up a 3 x 3 matrix
% You can also just directly enter the coefficents here rather than define
% the element values above.
% first row of the matrix
A11 = 1;
A12 = 1;
A13 = 1;
C11 = 1;
% second row of the matrix
A21 = 2;
A22 = 2;
A23 = 2;
C21 = 2;
% third ow of the matrix
A31 = 3;
A32 = 3;
A33 = 3;
C31 = 3;
% Name the "to be solved for" variables as you set them up  in your
% equations.
B11 = 'Var_1';
B21 = 'Var_2';
B31 = 'Var_3';
A = [A11 A12 A13; A21 A22 A23; A31 A32 A33];
C = [C11; C21; C31];
% The solution is B=A(inverse)*C
% Find the solution to the linear equations
B = inv(A)*C;
% now format the first variable found
B1_real = real(B(1));
B1_imag = imag(B(1));
[ThetaR1, Rho1] = cart2pol(B1_real,B1_imag);
ThetaD1 = ThetaR1/pi*180;
format_string = '\nRectangular %s = %.4f + j %.3f \n';
fprintf(format_string,B11,B1_real,B1_imag)
format_string = 'Polar %s = %.3f  Angle %.2f \n ';
fprintf(format_string,B11,Rho1,ThetaD1)
% now format the second variable found
B2_real = real(B(2));
B2_imag = imag(B(2));
[ThetaR2, Rho2] = cart2pol(B2_real,B2_imag);
ThetaD2 = ThetaR2/pi*180;
format_string = '\nRectangular %s = %.4f + j %.3f \n';
fprintf(format_string,B21,B2_real,B2_imag)
format_string = 'Polar %s = %.3f  Angle %.2f \n';
fprintf(format_string,B21,Rho2,ThetaD2)
% now format the third variable found
B3_real = real(B(3));
B3_imag = imag(B(3));
[ThetaR3, Rho3] = cart2pol(B3_real,B3_imag);
ThetaD3 = ThetaR3/pi*180;
format_string = '\nRectangular %s = %.4f + j %.3f \n';
fprintf(format_string,B31,B3_real,B3_imag)
format_string = 'Polar %s = %.3f  Angle %.2f \n';
fprintf(format_string,B31,Rho3,ThetaD3)
% End of the 3 x 3 Complex Matrix script
