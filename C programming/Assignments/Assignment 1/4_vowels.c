void main(){
//	4. Write a program to check whether a given character is a vowel or consonant.
	char ch;
	printf("ENter the letter from a to z: ");
	scanf("%c",&ch);
	
	if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'){
		
						printf("Its VOWEL");
					}
	
	else{
		printf("Its CONSONANT");
	}
}