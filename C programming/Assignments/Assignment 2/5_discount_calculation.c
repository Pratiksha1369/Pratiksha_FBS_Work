#include<stdio.h>
void main(){
//	5. Accept the price from user. Ask the user if he is a student (user may say y or n). If he
//is a student and he has purchased more than 500 than discount is 20% otherwise
//discount is 10%.But if he is not a student then if he has purchased more than 600
//discount is 15% otherwise there is not discount.

printf("*****Discount Criteria:*****\n");
printf("for student 20%% discount over 500RS shopping\n");
printf("for student 10%% discount less than 500RS shopping\n");
printf("for Non student 15%% discount over 600RS shopping\n");
printf("Otherwise NO DISCOUNT\n");

float price;
printf("\nEnter the price: ");
scanf("%f",&price);

char isStudent;
fflush(stdin);
printf("Are you a student?(Press y for yes & n for no): ");
scanf("%c",&isStudent);

float discount_price,finalPrice;

if(isStudent=='y'){
	if(price>500){
		printf("You get 20%% discount\n");
	
		discount_price = (0.20 * price);
		printf("You recive total discount:%.2f\n",discount_price);
	
		finalPrice = price-discount_price;
		printf("You have to pay:%.2f",finalPrice);
	}else{
		printf("You get 10%% discount\n");
	
		discount_price = (0.10 * price);
		printf("You recive total discount:%.2f\n",discount_price);
	
		finalPrice = price-discount_price;
		printf("You have to pay:%.2f",finalPrice);
		
	}
}else if(isStudent=='n' && price>600){
	printf("You get 15%% discount\n");
	
	discount_price = (0.15 * price);
	printf("You recive total discount:%.2f\n",discount_price);
	
	finalPrice = price-discount_price;
	printf("You have to pay:%.2f",finalPrice);
	
}else{
	
	printf("You are not eligible for any discount\n");
	printf("You have to pay:%.2f",price);
	
}
	


}