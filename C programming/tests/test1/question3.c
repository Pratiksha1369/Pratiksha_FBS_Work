void main(){
//	last two digits of a number

int num = 223410;
int d1,d2;
d1 = num%10;  //0
int r1 = num/10; 
//printf("%d",r1);
d2 = r1%10;  //1
//printf("%d",d2);

int number = d2*10 + d1;
printf("%d",number);


}