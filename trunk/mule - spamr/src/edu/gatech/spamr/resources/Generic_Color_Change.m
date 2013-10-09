clear all;
RGB1 = imread('filename');
[r1,c1,z1] = size(RGB1);
R1 = RGB1(:,:,1);
G1 = RGB1(:,:,2);
B1 = RGB1(:,:,3);
new_R1 = zeros(r1,c1);
new_G1 = zeros(r1,c1);
new_B1 = zeros(r1,c1);
for i1=1:r1
    for j1=1:c1
        if(R1(i1,j1)<255 && R1(i1,j1)>10 && G1(i1,j1)<255 && G1(i1,j1)>10 && B1(i1,j1)<255 && B1(i1,j1)>10)
            new_R1(i1,j1) = 0;
            new_G1(i1,j1) = 153;
            new_B1(i1,j1) = 0;
        else
            new_R1(i1,j1) = 0;
            new_G1(i1,j1) = 0;
            new_B1(i1,j1) = 0;
        end
    end
end
h1 = cat(3,new_R1,new_G1,new_B1);
imwrite(h1,'filename')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all;
RGB2 = imread('filename');
[r2,c2,z2] = size(RGB2);
R2 = RGB2(:,:,1);
G2 = RGB2(:,:,2);
B2 = RGB2(:,:,3);
new_R2 = zeros(r2,c2);
new_G2 = zeros(r2,c2);
new_B2 = zeros(r2,c2);
for i2=1:r2
    for j2=1:c2
        if(R2(i2,j2)<255 && R2(i2,j2)>10 && G2(i2,j2)<255 && G2(i2,j2)>10 && B2(i2,j2)<255 && B2(i2,j2)>10)
            new_R2(i2,j2) = 153;
            new_G2(i2,j2) = 0;
            new_B2(i2,j2) = 0;
        else
            new_R2(i2,j2) = 0;
            new_G2(i2,j2) = 0;
            new_B2(i2,j2) = 0;
        end
    end
end
h2 = cat(3,new_R2,new_G2,new_B2);
imwrite(h2,'filename')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all;
RGB3 = imread('filename');
[r3,c3,z3] = size(RGB3);
R3 = RGB3(:,:,1);
G3 = RGB3(:,:,2);
B3 = RGB3(:,:,3);
new_R3 = zeros(r3,c3);
new_G3 = zeros(r3,c3);
new_B3 = zeros(r3,c3);
for i3=1:r3
    for j3=1:c3
        if(R3(i3,j3)<255 && R3(i3,j3)>10 && G3(i3,j3)<255 && G3(i3,j3)>10 && B3(i3,j3)<255 && B3(i3,j3)>10)
            new_R3(i3,j3) = 0;
            new_G3(i3,j3) = 0;
            new_B3(i3,j3) = 153;
        else
            new_R3(i3,j3) = 0;
            new_G3(i3,j3) = 0;
            new_B3(i3,j3) = 0;
        end
    end
end
h3 = cat(3,new_R3,new_G3,new_B3);
imwrite(h3,'filename')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all;
RGB4 = imread('filename');
[r4,c4,z4] = size(RGB4);
R4 = RGB4(:,:,1);
G4 = RGB4(:,:,2);
B4 = RGB4(:,:,3);
new_R4 = zeros(r4,c4);
new_G4 = zeros(r4,c4);
new_B4 = zeros(r4,c4);
for i4=1:r4
    for j4=1:c4
        if(R4(i4,j4)<255 && R4(i4,j4)>10 && G4(i4,j4)<255 && G4(i4,j4)>10 && B4(i4,j4)<255 && B4(i4,j4)>10)
            new_R4(i4,j4) = 225;
            new_G4(i4,j4) = 225;
            new_B4(i4,j4) = 0;
        else
            new_R4(i4,j4) = 0;
            new_G4(i4,j4) = 0;
            new_B4(i4,j4) = 0;
        end
    end
end
h4 = cat(3,new_R4,new_G4,new_B4);
imwrite(h4,'filename');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%