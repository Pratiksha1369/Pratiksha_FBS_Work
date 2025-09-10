//Q2 number positive negative or neutral

#include<stdio.h>
void num_type(int num);
void main(){
	int num;
	printf("Enter number: ");
	scanf("%d",&num);
	
	num_type(num);
}

void num_type(int num){
	if(num>0){
		printf("Positive");
	}else if(num<0){
		printf("Negative");
	}else{
		printf("Neutral");
	}
}