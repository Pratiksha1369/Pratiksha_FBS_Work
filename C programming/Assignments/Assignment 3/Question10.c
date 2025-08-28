void main(){
//	Find Sum of first and last digit of given number.
//Input: n = 12345
//Output: 6 (1 + 5)

int num,rem,sum,original;
printf("Enter number: ");
scanf("%d",&num);

original=num;

rem=num%10;	
//while(num>=10){
//	
//	num=num/10;
//}


for(;num>=10;num=num/10){
	printf("%d \n",num);
}
	printf("The Original number is:%d\n",original);
	printf("The first digit is:%d\n",num);
	printf("The Last digit is:%d\n",rem);
	printf("The sum of FD and LD is:%d",num+rem);
	
}







