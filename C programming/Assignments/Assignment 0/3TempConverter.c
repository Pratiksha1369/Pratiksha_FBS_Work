//Write a C program to convert temperature from Celsius to Fahrenheit using the
//formula:
//F = (C *9/5) + 32

void main(){
	double tempCelcius = 32;
	double tempfah = (tempCelcius * 9.0/5) + 32;
	printf("The temperature in Fahrenheit is: %.2f",tempfah);
	
}
