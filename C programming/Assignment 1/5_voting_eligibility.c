void main(){
//	5. Write a program to check whether a person is eligible to vote (age = 18).
	int age;
	printf("Enter your age: ");
	scanf("%d",&age);
	
	if(age>=18){
		printf("Congrates!!\nYour are ELIGIBLE for vote");
	}else{
		printf("You are NOT ELIGIBLE for vote!!");
	}
}