void main(){
//	6 Check the given number is Perfect number or not.
//Input: n = 28
//Output: Perfect

int num=28,i=1,sum=0;
int original =num;

while(i<num){
	if(num%i==0){
		sum=sum+i;
		
	}
	i++;
}
printf("Sum is:%d\n",sum);

if(sum==original){
	printf("Perfect Number");
}else{
	printf("Not perfect number");
}
}