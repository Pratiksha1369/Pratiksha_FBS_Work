void main(){
//	4 Check the given number is prime or not.
//Input: n = 7
//Output: Prime

int num=1,i=2,isPrime=1;
//
if(num<=1){
	printf("Not prime");
	return 0;
	
}
while(i<num){
	if(num%i==0){
		isPrime = 0;  //condition false
		break;
	}
	i++;
	}
	if(isPrime=1){
		printf("Prime");
	}else{
		printf("Not Prime");
	}
}
