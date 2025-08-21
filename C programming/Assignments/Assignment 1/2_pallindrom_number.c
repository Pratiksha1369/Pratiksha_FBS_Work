void main(){
//	2. Write a program to check given 3 digit number is pallindrome or not.
	
	int num = 121;
	int d1 = num % 10;  //3
	int r1 = num /10;   //12
	int d2 = r1 % 10;	//2
	int d3 = r1 /10;	//1
	int rev = d1*100 + d2*10 + d3;
	if(num == rev){
		printf("The given number is pallindrome");
	} else{
		printf("The given number is not pallindrome");
	}
	 
	
}