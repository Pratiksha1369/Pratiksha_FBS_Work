void main(){
//	6. Write a program to check whether a given character is uppercase or lowercase.
	char ch;
	printf("ENter the letter from a to z: ");
	scanf("%c",&ch);
	
	if(ch>='A' && ch<='Z'){
		printf("Its UPPERCASE");
	}else if(ch>='a' && ch<='z'){
		printf("Its LOWERCASE");
	}else{
		printf("ITS NOT LETTER");
	}
}