void main(){
//	3. Write a program to check whether a given year is a leap year.
	int year = 2025;
	
	if(year%4==0 && year%100!=0 || year%400==0){
		printf("The give year is LEAP YEAR");
	}else{
		printf("The given year is NOT LEAP YEAR");
	}
}