void main(){
//	find factorial n=5,o/p=120

int num=5,fact=1,i=1;
while(i<=num){
	fact=fact*i;
	i++;
}
printf("The Factorial of %d is:%d",num,fact);
}