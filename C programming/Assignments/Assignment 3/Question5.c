void main(){
//	5 Check the given number is Armstrong number or not..
//Input: n = 153
//Output: Armstrong

int num=153,rem,sum=0;
int original=num;
while(num>0){
	rem=num%10;
	sum=sum+rem*rem*rem;
	num=num/10;
	
}
printf("Sum is:%d\n",sum);
if(sum==original){
	printf("Armstrong number");
}else{
	printf("Not Armstrong number");
}
}