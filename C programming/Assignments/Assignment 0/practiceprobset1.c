void main(){

//Greatest of Three Numbers
//Find the largest number among three hardcoded integers using only conditional operators (?:).
int a,b,c;
printf("Enter the 1st number: ");
scanf("%d",&a);

printf("Enter the 2nd number: ");
scanf("%d",&b);

printf("Enter the 3rd number: ");
scanf("%d",&c);

if(a>b && a>c){
	printf("1st no is gretest that is %d",a);
	
}else if(b>a && b>c){
	printf("The 2nd no is greatest that is %d",b);
}else{
	printf("The 3rd no. is greatest that is %d",c);
}



}