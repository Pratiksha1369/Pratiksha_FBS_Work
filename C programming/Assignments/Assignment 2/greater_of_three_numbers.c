void main(){
	int a,b,c;
	printf("Enter three numbers: ");
	scanf("%d",&a);
	scanf("%d",&b);
	scanf("%d",&c);
	
	if(a>b){
		if(a>c){
			printf("%d is greater",a);
		}else{
			printf("%d is greater",c);
		}
	}else if(b>c){
		printf("%d is greater",b);
	}else{
		printf("%d is greater",c);
	}


}





