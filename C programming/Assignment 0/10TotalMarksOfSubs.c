//10. Write a C program to input marks of five subjects, find the total marks, and calculate 
//the percentage.

void main(){
	int sub1 = 90;
	int sub2 = 80;
	int sub3 = 85;
	int sub4 = 95;
	int sub5 = 87;
	
	int totalMarks = sub1+sub2+sub3+sub4+sub5;
	float percent = (totalMarks/500.0)* 100;
	
	
	printf("the total marks are: %d\n",totalMarks);
	printf("The percentage is : %.2f %%",percent);
	
} 
