void main(){
//	Check the given number is Palindrome number or not.
//Input: n = 121
//Output: Palindrome

int num=121;
int rem,rev=0;
int original=num;
while(num>0){
	rem=num%10;
	rev=rev*10+rem;
	num=num/10;
}
printf("Original number:%d\n",original);
printf("Reverse number:%d\n",rev);

if(rev==original){
	printf("Pallindrome number");
}else{
	printf("Not a Pallindrome number");
}

}