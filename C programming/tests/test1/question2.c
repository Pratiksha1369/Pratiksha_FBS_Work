void main(){
//	year leap or not

int year;
printf("Enter a year: ");
scanf("%d",&year);

if(year%4==0 && year/100!=0 || year%400==0){
	printf("The year is Leap Year");
}else{
	printf("The year not leap year");
}
}