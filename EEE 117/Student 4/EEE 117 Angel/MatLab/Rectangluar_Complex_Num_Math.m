% Rectangluar Complex Number Math script
% This script finds the addition, subtraction, multiplication and division of two complex numbers.
% Written by Russ Tatro
% December 1, 2014
% clear the workspace and remove any "lingering" variables
clear all
clc
% Enter the two complex numbers in rectangular form
% In Matlab a rectangular number uses "i" and NOT "j"
A = 1;
B = 30+10*i;
% display the first complex number in rectangular form
CN1_Real = real(A);
CN1_Imag = imag(A);
format_string = '\nFirst number in Rectangular form is %.3f + j %.3f \n';
fprintf(format_string,CN1_Real,CN1_Imag)
% display the first complex number in polar form
[ThetaRA,RhoA] = cart2pol(real(A),imag(A));
ThetaDA = ThetaRA/pi*180;
format_string = '\nFirst number in Polar form is Magnitude %.3f at Angle %.2f in Degrees \n';
fprintf(format_string,RhoA,ThetaDA)
% display the second complex number in rectangular form
CN2_Real = real(B);
CN2_Imag = imag(B);
format_string = '\nSecond number in Rectangular form is %.3f + j %.3f \n';
fprintf(format_string,CN2_Real,CN2_Imag)
% display the second complex number in polar form
[ThetaRB,RhoB] = cart2pol(real(B),imag(B));
ThetaDB = ThetaRB/pi*180;
format_string = '\nSecond number in Polar form is Magnitude = %.3f at Angle %.2f Degrees \n \n';
fprintf(format_string,RhoB,ThetaDB)
%
% Find and display the addition which is also the series equivalent
CN_Add=A+B;
CN_Add_Real = real(CN_Add);
CN_Add_Imag = imag(CN_Add);
format_string = '\nAddition A + B = %.4f + j %.4f \n';
fprintf(format_string,CN_Add_Real, CN_Add_Imag)
[Theta_Add_R,Mag_Add] = cart2pol(CN_Add_Real, CN_Add_Imag);
Theta_Add_D = Theta_Add_R/pi*180;
format_string = '\nAddition Polar form A + B = %.4f at Angle %.2f Degrees \n \n';
fprintf(format_string,Mag_Add, Theta_Add_D)
%
% Find and display the subtraction
CN_Sub=A-B;
CN_Sub_Real = real(CN_Sub);
CN_Sub_Imag = imag(CN_Sub);
format_string = '\nSubtraction A - B = %.4f + j %.4f \n';
fprintf(format_string,CN_Sub_Real, CN_Sub_Imag)
[Theta_Sub_R,Mag_Sub] = cart2pol(CN_Sub_Real, CN_Sub_Imag);
Theta_Sub_D = Theta_Sub_R/pi*180;
format_string = '\nSubtraction Polar form A - B = %.4f at Angle %.2f Degrees \n \n';
fprintf(format_string,Mag_Sub, Theta_Sub_D)
% Find and display the multiplication
CN_Mult=A*B;
CN_Mult_Real = real(CN_Mult);
CN_Mult_Imag = imag(CN_Mult);
format_string = '\nMultiplication A * B = %.4f + j %.4f \n';
fprintf(format_string,CN_Mult_Real, CN_Mult_Imag)
[Theta_Mult_R,Mag_Mult] = cart2pol(CN_Mult_Real, CN_Mult_Imag);
Theta_Mult_D = Theta_Mult_R/pi*180;
format_string = '\nMultiplication Polar form A * B = %.4f at Angle %.2f Degrees \n \n';
fprintf(format_string,Mag_Mult, Theta_Mult_D)
%
% Find and display the divison
CN_Div=A/B;
CN_Div_Real = real(CN_Div);
CN_Div_Imag = imag(CN_Div);
format_string = '\nDivison A / B = %.4f + j %.4f \n ';
fprintf(format_string,CN_Div_Real, CN_Div_Imag)
[Theta_Div_R,Mag_Div] = cart2pol(CN_Div_Real, CN_Div_Imag);
Theta_Div_D = Theta_Div_R/pi*180;
format_string = '\nDivision Polar form A / B = %.4f at %.2f Angle (Degrees) \n \n';
fprintf(format_string,Mag_Div, Theta_Div_D)
% End of the Rectangular Complex Math script


