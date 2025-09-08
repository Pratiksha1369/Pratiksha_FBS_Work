void main(){
	int num=5;
	int count=1;
	for(int i=1;i<=num;i++){
		for(int j=1;j<=i;j++){
			printf("%d ",count++);
		}
		printf("\n");
	}
}