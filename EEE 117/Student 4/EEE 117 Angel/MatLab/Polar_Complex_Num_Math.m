%  Polar Complex Number Math Script
% This script finds the addition, subtraction, multiplication and division of two polar complex numbers.
% Written by Russ Tatro
% April 25, 2015
% Convert polar to rectangular then add then convert to polar
clear all
clc
% Enter the first phasor
Mag1 = 12;
ThetaD1 = -90;
% if in cosine just write the angle
% if in sine then subtract 90 degrees
ThetaR1 = ThetaD1/180*pi;
% Enter the second phasor
Mag2 = 0.121;
ThetaD2 = -65.56;
ThetaR2 = ThetaD2/180*pi;
% display the first complex number in polar form
format_string = '\nFirst number in Polar form is Magnitude %.3f at Angle %.2f in Degrees \n';
fprintf(format_string,Mag1,ThetaD1)
% First number in rectangular form
% I am using the polar to cartesian function pol2cart
[X1,Y1] = pol2cart(ThetaR1,Mag1);
format_string = '\nFirst Number in Rectangular form = %.4f + j %.4f \n';
fprintf(format_string,X1,Y1)
% Display the second number
% display the second complex number in polar form
format_string = '\nSecond number in Polar form is Magnitude %.3f at Angle %.2f in Degrees \n';
fprintf(format_string,Mag2,ThetaD2)
% Second number in rectangular form
[X2,Y2] = pol2cart(ThetaR2,Mag2);
format_string = '\nSecond Number in Rectangular form = %.4f + j %.4f \n \n';
fprintf(format_string,X2,Y2)
% Find and display the addition which is also the series equivalent
A = X1+Y1*i;
B = X2+Y2*i;
CN_Add=A+B;
CN_Add_Real = real(CN_Add);
CN_Add_Imag = imag(CN_Add);
[Theta_Add_R,Mag_Add] = cart2pol(CN_Add_Real, CN_Add_Imag);
Theta_Add_D = Theta_Add_R/pi*180;
format_string = '\nAddition Polar form A + B = %.4f at %.2f Angle (Degrees) \n';
fprintf(format_string,Mag_Add, Theta_Add_D)
format_string = '\nAddition Rectangular form A + B = %.4f + j %.4f \n \n';
fprintf(format_string,CN_Add_Real, CN_Add_Imag)
% Find and display the subtraction
CN_Sub=A-B;
CN_Sub_Real = real(CN_Sub);
CN_Sub_Imag = imag(CN_Sub);
[Theta_Sub_R,Mag_Sub] = cart2pol(CN_Sub_Real, CN_Sub_Imag);
Theta_Sub_D = Theta_Sub_R/pi*180;
format_string = '\nSubtraction Polar form A - B = %.4f at %.2f Angle (Degrees) \n';
fprintf(format_string,Mag_Sub, Theta_Sub_D)
format_string = '\nSubtraction Rectangular form A - B = %.4f + j %.4f \n \n';
fprintf(format_string,CN_Sub_Real, CN_Sub_Imag)
% Find and display the multiplication
CN_Mult=A*B;
CN_Mult_Real = real(CN_Mult);
CN_Mult_Imag = imag(CN_Mult);
[Theta_Mult_R,Mag_Mult] = cart2pol(CN_Mult_Real, CN_Mult_Imag);
Theta_Mult_D = Theta_Mult_R/pi*180;
format_string = '\nMultiplication Polar form A * B = %.4f at %.2f Angle (Degrees) \n';
fprintf(format_string,Mag_Mult, Theta_Mult_D)
format_string = '\nMultiplication Rectangular form A * B = %.4f + j %.4f \n \n';
fprintf(format_string,CN_Mult_Real, CN_Mult_Imag)
% Find and display the divison
CN_Div=A/B;
CN_Div_Real = real(CN_Div);
CN_Div_Imag = imag(CN_Div);
[Theta_Div_R,Mag_Div] = cart2pol(CN_Div_Real, CN_Div_Imag);
Theta_Div_D = Theta_Div_R/pi*180;
format_string = '\nDivision Polar form A / B = %.4f at %.2f Angle (Degrees) \n';
fprintf(format_string,Mag_Div, Theta_Div_D)
format_string = '\nDivison Rectangular form A / B = %.4f + j %.4f \n \n';
fprintf(format_string,CN_Div_Real, CN_Div_Imag)
% End of the Polar Complex Math script

