//6. Print a half pyramid using numbers 
//Input: n = 5 
//Output: 
//1 
//12 
//123 
//1234 
//12345

void main(){
	int n=5;
//	int count=0;
	for(int i=1;i<=n;i++){
		//count++;
		for(int j=1;j<=i;j++){
			printf("%d ",j);
		}
		printf("\n");
	}
}