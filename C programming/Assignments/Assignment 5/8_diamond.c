//8. Print a pattern of stars in diamond shape 
//Input: n = 4 
//Output: 
//* 
//** 
//*** 
//**** 
//*** 
//** 
//*

void main(){
	int num=4;
	for(int i=1;i<=num;i++){
		for(int space=1;space<=num-i;space++){
			printf(" ");
		}
		for(int j=1;j<=i;j++){
			printf("* ");
		}
		printf("\n");
	}
	
	for(int i=num-1;i>=1;i--){
		for(int space=1;space<=num-i;space++){
			printf(" ");
		}
		for(int j=1;j<=i;j++){
			printf("* ");
		}
		printf("\n");
	}
}