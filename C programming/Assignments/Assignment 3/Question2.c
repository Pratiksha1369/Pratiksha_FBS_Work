void main(){
//	Print table for given number.
//Input: n = 5
//Output: 5 10 15 20 25 30 35 40 45 50

//int num=5,i=1;
int num,i=1;
printf("Enter the number: ");
scanf("%d",&num);

printf("The table of %d is: \n",num);
while(i<=10){
	printf("%d * %d = %d\n",num,i,num*i);
	i++;
}

}