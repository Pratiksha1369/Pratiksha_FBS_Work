void main(){
//	1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the
//desired operations.

int a,b,choice;
printf("Enter 1st number: ");
scanf("%d",&a);
printf("Enter 2nd number: ");
scanf("%d",&b);

printf("Choose operation\n");
printf("press 1 for addition\n");
printf("press 2 for Subtraction\n");
printf("press 3 for Multiplication\n");
printf("press 4 for Division\n");
printf("press 5 for Modulous\n");

printf("\nWhat you want to perform?: ");
scanf("%d",&choice);

if(choice == 1){
	printf("The Addition is: %d",a+b);
}else if(choice == 2){
	printf("The Subtraction is: %d",a-b);
}else if(choice == 3){
	printf("The Multiplication is: %d",a*b);
}else if(choice == 4){
	if(b == 0){
		printf("Denominator must be Non-Zero!");
	}else{
		printf("The Division is: %d",a/b);
	}
}else if(choice == 5){
	printf("The Modulous is: %d",a%b);
}else{
	printf("INVALID INPUT!");
}
}





