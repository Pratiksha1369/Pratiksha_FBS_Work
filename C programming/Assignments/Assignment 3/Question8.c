void main(){
//	8 Check the given number is Strong number or not.
//Input: n = 145
//Output: Strong

int num=145,fact,rem,i,sum=0;
int original=num;
while(num>0){
	rem=num%10;	
	fact=1;
	i=1;
	while(i<=rem){
		fact=fact*i;
		i++;
	}
   sum = sum+fact;
	num=num/10;
	
}
printf("%d\n",sum);
if(sum==original){
	printf("Strong Number");
}else{
	printf("Not Strong number");
}

}